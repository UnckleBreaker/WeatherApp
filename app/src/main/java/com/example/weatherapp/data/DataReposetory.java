package com.example.weatherapp.data;

import com.example.weatherapp.data.API.ApiFactory;
import com.example.weatherapp.data.cache.WeatherCacheTransformer;
import com.example.weatherapp.data.mapper.WeatherMapper;
import com.example.weatherapp.domain.WeatherProvider;
import com.example.weatherapp.domain.WeatherResponce;

import io.reactivex.Observable;

public class DataReposetory implements WeatherProvider {

    public String city;

    public DataReposetory(String city) {
        this.city = city;
    }

    @Override
public Observable<WeatherResponce> getWeatherResponce() {
        return ApiFactory.getWeatherApi()
        .getWeather(city)
        //   .compose(new WeatherCacheTransformer())
        .map(new WeatherMapper());
        }
        }
