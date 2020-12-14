package com.ghamsari.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.ghamsari.weather.utils.LocationWeather;
import com.ghamsari.weather.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {
WeatherViewModel WeatherViewModel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationWeather view = new LocationWeather();
        view.getLocation(MainActivity.this);


    }

    private  void initViewModel (){
        WeatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);


    }

}