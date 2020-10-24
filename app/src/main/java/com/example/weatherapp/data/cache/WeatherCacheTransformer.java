package com.example.weatherapp.data.cache;

import android.content.Context;

import com.example.weatherapp.data.responce.WeatherResponce;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.realm.Realm;
import io.realm.RealmResults;


public class WeatherCacheTransformer extends WeatherResponce implements ObservableTransformer<WeatherResponce,WeatherResponce> {

    Context context;
    private final Function<WeatherResponce, Observable<WeatherResponce>> mSaveFunc =  weather -> {
        Realm.getInstance(context).executeTransaction(realm -> {
            realm.clear(WeatherResponce.class);
            realm.copyToRealm(weather);;
        });
        return Observable.just(weather);
    };

    private final Function<Throwable, Observable<WeatherResponce>> mCacheErrorHandler = throwable -> {
        Realm realm = Realm.getInstance(context);
        RealmResults<WeatherResponce> results = realm.where(WeatherResponce.class).findAll();
        return Observable.just((WeatherResponce) realm.copyFromRealm(results));
    };

    @Override
    public ObservableSource<WeatherResponce> apply(Observable<WeatherResponce> moviesObservable) {
        return moviesObservable
                .flatMap(mSaveFunc)
                .onErrorResumeNext(mCacheErrorHandler);
    }
}
