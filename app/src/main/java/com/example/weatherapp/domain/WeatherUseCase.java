package com.example.weatherapp.domain;

import io.reactivex.Observable;

public class WeatherUseCase {
    private final WeatherProvider weatherProvider;


    public WeatherUseCase(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }
    public Observable <WeatherResponce> getWeather()
    {
        return weatherProvider.getWeatherResponce();
    }
}
