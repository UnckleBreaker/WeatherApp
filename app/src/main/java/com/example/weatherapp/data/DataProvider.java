package com.example.weatherapp.data;

import com.example.weatherapp.domain.WeatherProvider;

public class DataProvider {
    static WeatherProvider weatherProvider;

    public static WeatherProvider getWeatherProvider(String city)
    {
            weatherProvider =new DataReposetory(city);
        return weatherProvider;
    }
    public static void setWeatherProvider(WeatherProvider sweatherProvider)
    {
        weatherProvider =sweatherProvider;
    }

}
