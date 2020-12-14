package com.ghamsari.weather.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.ghamsari.weather.R;
import com.ghamsari.weather.model.WeatherDto;
import com.ghamsari.weather.utils.LocationWeather;
import com.ghamsari.weather.viewmodel.WeatherViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
WeatherViewModel WeatherViewModel ;

    LocationWeather view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = new LocationWeather();
        view.getLocation(MainActivity.this);
        initViewModel ();


   WeatherViewModel.getWeatherDeo().observe(this, new Observer<List<WeatherDto>>() {
       @Override
       public void onChanged(List<WeatherDto> weatherDtos) {

           TextView textTemperatures =(TextView)findViewById(R.id.temperatures_text);
           TextView textCondition =(TextView)findViewById(R.id.condition_text);
           TextView textHumidity =(TextView)findViewById(R.id.humidity_txt);
           TextView textWind =(TextView)findViewById(R.id.wind_text);
           LottieAnimationView animationView =(LottieAnimationView)findViewById(R.id.animationView);
          textTemperatures.setText(weatherDtos.get(0).getMain().getHumidity());
           textCondition.setText(weatherDtos.get(0).getWeather().get(0).getMain());
           textHumidity.setText(weatherDtos.get(0).getMain().getHumidity());
           textWind.setText(String.valueOf(weatherDtos.get(0).getWind().getSpeed()));
           animationView.setAnimation(view.showAnimation(weatherDtos.get(0).getWeather().get(0).getId()));
           animationView.playAnimation();
       }
   });
    }

    private  void initViewModel (){
        WeatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);


    }
}