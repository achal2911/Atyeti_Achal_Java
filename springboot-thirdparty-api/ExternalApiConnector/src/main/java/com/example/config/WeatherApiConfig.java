package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiConfig {


    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public String getApiKey() {
        return apiKey;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();

    }
}
