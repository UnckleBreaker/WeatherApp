package com.example.weatherapp.domain;

import java.util.List;

public class WeatherResponce {

    private List<com.example.weatherapp.data.responce.WeatherResponce.Weather> weather;
    private com.example.weatherapp.data.responce.WeatherResponce.Main main;

    private int visibility;
    private com.example.weatherapp.data.responce.WeatherResponce.Wind wind;
    private com.example.weatherapp.data.responce.WeatherResponce.Clouds clouds;

    public String getWeathermain() {
        return weather.get(0).main;
    }
    public String getWeatherdescription() {
        return weather.get(0).description;
    }

    public float getTemperature() {

        return Math.round(main.temp-273);
    }
    public float getPressure() {
        return main.pressure;
    }
    public float getHumidity() {
        return main.humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public com.example.weatherapp.data.responce.WeatherResponce.Wind getWind() {
        return wind;
    }

    public com.example.weatherapp.data.responce.WeatherResponce.Clouds getClouds() {
        return clouds;
    }

    public String getName() {
        return name;
    }

    private String name;


    public WeatherResponce(List<com.example.weatherapp.data.responce.WeatherResponce.Weather> weather, com.example.weatherapp.data.responce.WeatherResponce.Main main, int visibility, com.example.weatherapp.data.responce.WeatherResponce.Wind wind, com.example.weatherapp.data.responce.WeatherResponce.Clouds clouds, String name) {
        this.weather = weather;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.name = name;
    }
}
