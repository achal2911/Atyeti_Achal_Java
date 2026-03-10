package com.example.service;

import com.example.api.response.WeatherResponse;
import com.example.config.WeatherApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherService {


    @Autowired
    private WeatherApiConfig weatherConfig;
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String url = weatherConfig.getApiUrl(); // still has {API_KEY} & {CITY}

        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("API_KEY", weatherConfig.getApiKey());
        uriVars.put("CITY", city);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, WeatherResponse.class, uriVars);
        return response.getBody();
    }


}
