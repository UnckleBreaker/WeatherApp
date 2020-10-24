package com.example.weatherapp.data;

import com.example.weatherapp.data.API.ApiFactory;
import com.example.weatherapp.data.cache.WeatherCacheTransformer;
import com.example.weatherapp.data.mapper.WeatherMapper;
import com.example.weatherapp.domain.WeatherProvider;
import com.example.weatherapp.domain.WeatherResponce;

import io.reactivex.Observable;

public class DataReposetory implements WeatherProvider {


    @Override
    public Observable<WeatherResponce> getWeatherResponce() {
        return ApiFactory.getWeatherApi()
                .getWeather()
             //   .compose(new WeatherCacheTransformer())
                .map(new WeatherMapper());
    }
}
