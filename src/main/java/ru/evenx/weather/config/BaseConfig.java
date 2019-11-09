package ru.evenx.weather.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {



    @Bean
    public HttpClient getHttpClient() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        return builder.build();
    }
}
