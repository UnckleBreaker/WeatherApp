package com.example.weatherapp.data.API;

import com.example.weatherapp.data.responce.WeatherResponce;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiWeather {

    @GET("weather?&")
    Observable<WeatherResponce> getWeather(@Query("q") String q);
}
