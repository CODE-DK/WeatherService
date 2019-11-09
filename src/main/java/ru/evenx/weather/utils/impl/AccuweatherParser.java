package ru.evenx.weather.utils.impl;

import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Component;
import ru.evenx.weather.pojo.CityWeather;
import ru.evenx.weather.utils.WeatherParser;

@Component("base-parser")
public class AccuweatherParser implements WeatherParser {
    @Override
    public CityWeather parseResponse(String response) {
        String temperature = JsonPath.read(response, "$.[0].Temperature.Metric.Value").toString();
        String humidity = JsonPath.read(response, "$.[0].RelativeHumidity").toString();
        String pressure = JsonPath.read(response, "$.[0].Pressure.Metric.Value").toString();
        CityWeather cityWeather = new CityWeather();
        cityWeather.setTemperature(temperature + " \u00B0C");
        cityWeather.setHumidity(humidity + "%");
        cityWeather.setPressure(pressure + " мбар");
        return cityWeather;
    }
}
