package ru.evenx.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.evenx.weather.pojo.CityWeather;
import ru.evenx.weather.service.LocalWeatherService;
import ru.evenx.weather.service.remote.RemoteService;

import java.io.IOException;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private LocalWeatherService localService;
    @Autowired
    private RemoteService remoteService;

    @GetMapping("get")
    public CityWeather getWeather(@RequestParam("remote-service") String serviceName,
                                  @RequestParam("city") String city) throws IOException {
        String url = remoteService.getUrl(city, serviceName);
        return localService.remoteCall(url);
    }
}
