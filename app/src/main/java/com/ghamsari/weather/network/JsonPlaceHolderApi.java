package com.ghamsari.weather.network;

import com.ghamsari.weather.model.Weather;
import com.ghamsari.weather.model.WeatherDto;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("weather")
    Observable<List<WeatherDto>> getWeather(@Query("lat") String lat , @Query("lon") String lon , @Query("units") String units,
                                            @Query("appid") String key);
}
