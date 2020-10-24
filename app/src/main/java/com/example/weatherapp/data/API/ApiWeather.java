package com.example.weatherapp.data.API;

import com.example.weatherapp.data.responce.WeatherResponce;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiWeather {

    @GET("weather?q=London&")
    Observable<WeatherResponce> getWeather();
}
