package com.ghamsari.weather.utils;

import android.util.Log;

public class DataHolder {
    private  static String lat ;
    private  static String lon ;

    public static String getLat() {
        return lat;
    }

    public static String getLon() {
        return lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
        Log.i("my app dataholder","your log is" +lat );
    }

    public void setLon(String lon) {
        this.lon = lon;
        Log.i("my app dataholder","your log is" +lon);
    }
}
