package com.example.weatherapp.data;

import com.example.weatherapp.domain.WeatherProvider;

public class DataProvider {
    static WeatherProvider weatherProvider;

    public static WeatherProvider getWeatherProvider()
    {
        if(weatherProvider ==null){
            weatherProvider =new DataReposetory();
        }
        return weatherProvider;
    }
    public static void setWeatherProvider(WeatherProvider sweatherProvider)
    {
        weatherProvider =sweatherProvider;
    }

}
