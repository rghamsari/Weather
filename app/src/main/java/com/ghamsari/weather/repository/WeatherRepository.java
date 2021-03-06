package com.ghamsari.weather.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ghamsari.weather.model.WeatherDto;
import com.ghamsari.weather.network.ApiClient;
import com.ghamsari.weather.network.JsonPlaceHolderApi;
import com.ghamsari.weather.utils.DataHolder;
import android.util.Log;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class WeatherRepository {
    private final JsonPlaceHolderApi jsonPlaceHolderApi ;
    private   MutableLiveData <List<WeatherDto>> mutableLiveData = new MutableLiveData<>() ;

    public WeatherRepository() {
       jsonPlaceHolderApi = ApiClient.getRetrofitInstance().create(JsonPlaceHolderApi.class);
    }
    public LiveData<List<WeatherDto>> getLocationWeatherDitel () {
        Log.i("my app location","your log is " +DataHolder.getLat());
        jsonPlaceHolderApi.getWeather(DataHolder.getLat(),
                DataHolder.getLon(),
                "metric",
                "6ff87ae2cecff28bf3919d0106f692fb")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<WeatherDto>>() {
            @Override
            public void onNext(@NonNull List<WeatherDto> weatherDtos) {
                mutableLiveData.postValue(weatherDtos);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
}
}