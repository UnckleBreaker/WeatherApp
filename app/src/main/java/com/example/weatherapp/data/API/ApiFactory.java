package com.example.weatherapp.data.API;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static OkHttpClient SokHttpClient;
    private static ApiWeather SapiWeather;

    public static ApiWeather getWeatherApi()
    {
        ApiWeather apiWeather = SapiWeather;
        if(apiWeather ==null)
        {
            synchronized (ApiWeather.class)
            {
                apiWeather=SapiWeather;
                if(apiWeather==null)
                    apiWeather=SapiWeather=createService();
            }
        }
        return apiWeather;
    }

    private static ApiWeather createService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiWeather.class);
    }

    private static OkHttpClient getClient() {
        OkHttpClient okHttpClient =SokHttpClient;
        if (okHttpClient == null) {
            synchronized (ApiFactory.class) {
                okHttpClient = SokHttpClient;
                if (okHttpClient == null) {
                    okHttpClient = SokHttpClient = buildClient();
                }
            }
        }
        return okHttpClient;


    }

    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyInterceptor())
                .build();
    }

}
