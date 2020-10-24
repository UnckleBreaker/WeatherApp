package com.example.weatherapp.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.data.DataProvider;
import com.example.weatherapp.domain.WeatherResponce;
import com.example.weatherapp.domain.WeatherUseCase;

public class WeatherActivity extends AppCompatActivity implements WeatherView {
    public TextView T_City_name;

    public TextView T_City_temp;
    public TextView T_City_temp1;
    public TextView T_City_pressue;
    public TextView T_City_humidity;
    public TextView T_City_visability;
    public TextView T_City_description;
    public TextView T_City_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T_City_name = findViewById(R.id.city_name);
        T_City_temp = findViewById(R.id.city_temperature);
        T_City_temp1 = findViewById(R.id.temp);
        T_City_pressue =findViewById(R.id.pressue);
        T_City_humidity= findViewById(R.id.humidity);
        T_City_visability= findViewById(R.id.visability);
        T_City_description= findViewById(R.id.description);
        T_City_main= findViewById(R.id.main);

        WeatherUseCase weatherUseCase = new WeatherUseCase(DataProvider.getWeatherProvider());
        WeatherPresenter weatherPresenter = new WeatherPresenter(this,weatherUseCase);
        weatherPresenter.init();
    }


    @Override
    public void showdata(WeatherResponce weatherResponce) {
        T_City_temp1.setText(String.valueOf(weatherResponce.getTemperature() +"C"));
        T_City_name.setText(weatherResponce.getName());
        T_City_temp.setText(String.valueOf(weatherResponce.getTemperature()));
        T_City_description.setText(weatherResponce.getWeatherdescription());
        T_City_humidity.setText(String.valueOf(weatherResponce.getHumidity()));
        T_City_main.setText(weatherResponce.getWeathermain());
        T_City_visability.setText(String.valueOf(weatherResponce.getVisibility()));
        T_City_pressue.setText(String.valueOf(weatherResponce.getPressure()));

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show();
    }
}