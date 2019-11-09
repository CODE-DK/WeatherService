package ru.evenx.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evenx.weather.pojo.CityWeather;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @GetMapping("get")
    public CityWeather getWeather(){
        return new CityWeather("city", "80%", "735mm.rt", "28C");
    }
}
