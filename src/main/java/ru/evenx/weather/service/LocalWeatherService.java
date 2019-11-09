package ru.evenx.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.evenx.weather.pojo.CityWeather;
import ru.evenx.weather.service.remote.RemoteService;
import ru.evenx.weather.service.remote.RemoteWeatherService;
import ru.evenx.weather.utils.WeatherParser;

import java.io.IOException;
import java.util.Optional;

@Component
public class LocalWeatherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalWeatherService.class);
    @Autowired
    private HttpClient client;
    @Autowired
    @Qualifier("base-parser")
    private WeatherParser weatherParser;

    public CityWeather remoteCall(String url) throws IOException {
        Optional<HttpResponse> response = getResponse(url);
        if (response.isPresent()) {
            CityWeather cityWeather = weatherParser.parseResponse(EntityUtils.toString(response.get().getEntity()));
            return cityWeather;
        } return null;
    }

    private Optional<HttpResponse> getResponse(String url) {
        HttpGet request = new HttpGet(url);
        try {
            return Optional.ofNullable(client.execute(request));
        } catch (IOException e) {
            LOGGER.error("FAIL during remote call {}", e.getMessage());
        }
        return Optional.empty();
    }
}
