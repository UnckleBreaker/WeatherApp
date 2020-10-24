package com.example.weatherapp.data.mapper;

import com.example.weatherapp.data.responce.WeatherResponce;

import io.reactivex.functions.Function;

public class WeatherMapper implements Function<WeatherResponce, com.example.weatherapp.domain.WeatherResponce> {

    @Override
    public com.example.weatherapp.domain.WeatherResponce apply(WeatherResponce weatherResponce) {
        return new com.example.weatherapp.domain.WeatherResponce(weatherResponce.getWeather(),weatherResponce.getMain(),weatherResponce.getVisibility(),weatherResponce.getWind(),weatherResponce.getClouds(),weatherResponce.getName());
    }
}
