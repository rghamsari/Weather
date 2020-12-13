package com.ghamsari.weather.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ghamsari.weather.model.WeatherDto;
import com.ghamsari.weather.repository.WeatherRepository;

import java.util.List;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository repository;
    private MutableLiveData<List<WeatherDto>> mWeatherDeo;

    public WeatherViewModel(String lat , String lon) {
        mWeatherDeo = (MutableLiveData<List<WeatherDto>>) repository.getLocationWeatherDitel(lat,lon);
    }

    public LiveData<List<WeatherDto>> getWeatherDeo(){

        return mWeatherDeo;
    }
}
