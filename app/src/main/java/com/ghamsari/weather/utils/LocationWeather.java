package com.ghamsari.weather.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;

import com.ghamsari.weather.R;
import com.ghamsari.weather.model.Weather;
import com.ghamsari.weather.model.WeatherDto;
import com.ghamsari.weather.viewmodel.WeatherViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationWeather {
    private  Context context;
    private Activity activity;

    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    public int showAnimation (int code) {
        int Code = code / 100;

        switch (Code) {
            case 2:
                return R.raw.storm_weather;
            case 3:
                return R.raw.rainy_weather;
            case 4:
                return R.raw.snow_weather;
            case 5:
                return R.raw.unknown;
            case 6:
                return R.raw.clear_day;
            case 7:
                return R.raw.broken_clouds;
            case 8:
                return R.raw.broken_clouds;
            default:
                return R.raw.rainy_weather;

        }

    }




    public void getLocation(Activity activity){
        this.activity =activity;
        context =  activity.getApplicationContext();
        ActivityCompat.requestPermissions( activity, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        locationManager = (LocationManager) activity.getSystemService(activity.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            OnGPS();
        } else {
            location();
        }



    }

    private void location() {
        if (ActivityCompat.checkSelfPermission(
                context,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            android.location.Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                DataHolder dataHolder =new DataHolder();
                dataHolder.setLat(String.valueOf(lat));
                Log.i("myappdataholder","your log is" +lat );
                dataHolder.setLon(String.valueOf(longi));
                Log.i("myappdataholder","your log is" +longi );


             } else {
                Toast.makeText(context, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void OnGPS() {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

//        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//               context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
//            }
//        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//        final AlertDialog alertDialog = builder.create();
//        alertDialog.show();
    }
    


}


