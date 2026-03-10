package com.example.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class WeatherResponse {
    public Current getCurrent() {
        return current;
    }

    // explicitly add this
    private Current current;


    @Getter
    @Setter
    public class Current{

        public int temperature;

        public int feelslike;

        public int getTemperature() {
            return temperature;
        }


        public int getFeelslike() {
            return feelslike;
        }
    }
}
