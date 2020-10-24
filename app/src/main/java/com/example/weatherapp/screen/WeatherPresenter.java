package com.example.weatherapp.screen;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.domain.WeatherUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherPresenter extends AppCompatActivity {
    public final WeatherView weatherView;
    public final WeatherUseCase weatherUseCase;
    public String TAG= this.getClass().getSimpleName();
    public WeatherPresenter(WeatherView weatherView, WeatherUseCase weatherUseCase) {
        this.weatherView = weatherView;
        this.weatherUseCase = weatherUseCase;
    }
    @SuppressLint("CheckResult")
    public void init() {
        weatherUseCase.getWeather()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i-> {weatherView.showdata(i); Log.d(TAG, i.getName() );  }, throwable -> {weatherView.showError(throwable.getMessage()); Log.d(TAG, throwable.getMessage() );

                });
    }
}
