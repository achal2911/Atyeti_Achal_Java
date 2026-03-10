package com.variables.temperatureconverter;

public class TemperatureConverter {

    // Celsius to Fahrenheit
    public float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Celsius to Kelvin
    public float celsiusToKelvin(float celsius) {
        return celsius + 273.15f;
    }

    // Fahrenheit to Celsius
    public float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Kelvin to Celsius
    public float kelvinToCelsius(float kelvin) {
        return kelvin - 273.15f;
    }

    public void findingOverflow(float value) {
        System.out.println("\nDemonstrating Overflow:");
        System.out.println("\nOriginal float value of temperature: " + value);

        //manual casting of temperature(float) to byte and short
        byte overflowByte = (byte) value;
        short overflowShort = (short) value;

        //After casting
        System.out.println(" temperature  to byte  (range -128 to 127): " + overflowByte);
        System.out.println("temperature to short (range -32,768 to 32,767): " + overflowShort);


    }

    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        float temperatureInCelsius = 1000.0f;

        System.out.println("Temperature Conversions for " + temperatureInCelsius + "°C:");

        System.out.println("Celsius to Fahrenheit: " + converter.celsiusToFahrenheit(temperatureInCelsius) + "°F");
        System.out.println("Celsius to Kelvin    : " + converter.celsiusToKelvin(temperatureInCelsius) + "K");

        // Overflow of variables
        converter.findingOverflow(temperatureInCelsius);
    }


}
