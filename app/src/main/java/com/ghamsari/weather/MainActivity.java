package com.ghamsari.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ghamsari.weather.utils.LocationWeather;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationWeather view = new LocationWeather();
        view.getLocation(MainActivity.this);
    }
}