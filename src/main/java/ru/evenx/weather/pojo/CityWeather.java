package ru.evenx.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CityWeather {
    private String city;
    private String humidity;
    private String pressure;
    private String temperature;
}
