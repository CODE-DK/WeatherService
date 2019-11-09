package ru.evenx.weather.service.remote;

import org.springframework.stereotype.Component;

@Component
public class RemoteWeatherService implements RemoteService {

    @Override
    public String getUrl(String city, String service) {
        return "http://dataservice.accuweather.com/currentconditions/v1/1-295863_1_AL?apikey=bopAMwG1ZSYlgP4VsffODxHp1B4i8E06&language=ru&details=true";
    }
}
