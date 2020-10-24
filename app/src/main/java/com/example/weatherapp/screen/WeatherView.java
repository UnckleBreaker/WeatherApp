package com.example.weatherapp.screen;

import com.example.weatherapp.domain.WeatherResponce;

import io.reactivex.annotations.NonNull;

public interface WeatherView {
     void showdata( @NonNull WeatherResponce weatherResponce);
     void showError(String message);
}
