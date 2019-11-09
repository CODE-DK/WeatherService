package ru.evenx.weather.utils.impl;

import org.springframework.context.annotation.Configuration;
import ru.evenx.weather.pojo.CityWeather;
import ru.evenx.weather.utils.WeatherParser;

@Configuration
public class WorldweatheronlineParser implements WeatherParser {
    @Override
    public CityWeather parseResponse(String response) {
        throw new RuntimeException("not used");
    }
}
