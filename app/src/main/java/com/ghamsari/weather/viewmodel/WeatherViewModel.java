package com.ghamsari.weather.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.ghamsari.weather.model.WeatherDto;
import com.ghamsari.weather.repository.WeatherRepository;
import com.ghamsari.weather.utils.DataHolder;

import java.util.List;

public class WeatherViewModel extends ViewModel {
    private WeatherRepository repository= new WeatherRepository();
    private MutableLiveData<List<WeatherDto>> mWeatherDeo;

    public void init() {

      //  repository = new WeatherRepository();
        Log.i("my app location","you are  in view model1");
        mWeatherDeo = (MutableLiveData<List<WeatherDto>>) repository.getLocationWeatherDitel();
        Log.i("my app location","you are  in view model");
    }

    public LiveData<List<WeatherDto>> getWeatherDeo(){
        mWeatherDeo = (MutableLiveData<List<WeatherDto>>) repository.getLocationWeatherDitel();
        return mWeatherDeo;
    }
}
