package com.example.weatherapp.data.API;

import com.example.weatherapp.BuildConfig;
import com.example.weatherapp.R;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request =chain.request();
        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("appid","8a29b63838cdbd86502c804767d21b4e")
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
