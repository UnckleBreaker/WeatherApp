package com.example.weatherapp.domain;

import io.reactivex.Observable;

public interface WeatherProvider {
    Observable<WeatherResponce> getWeatherResponce();
}
