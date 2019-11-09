package ru.evenx.weather.utils;

import ru.evenx.weather.pojo.CityWeather;

public interface WeatherParser {
    CityWeather parseResponse(String response);
}
