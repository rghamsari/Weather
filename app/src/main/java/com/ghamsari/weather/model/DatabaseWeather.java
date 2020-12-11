package com.ghamsari.weather.model;

public class DatabaseWeather {
    private double Lon;
    private double Lat;
    private String Main;
    private double Speed;
    private double Temp;
    private int Humidity;

    public DatabaseWeather() {

    }

    public DatabaseWeather(double lon, double lat) {
        this.Lon = lon;
        this.Lat = lat;
    }

    public double getLon() {
        return Lon;
    }

    public double getLat() {
        return Lat;
    }

    public String getMain() {
        return Main;
    }

    public String getSpeed() {
        return Speed +" km/hr";
    }

    public double getTemp() {
        return Temp ;
    }

    public String getHumidity() {
        return Humidity + " %";
    }

    public void setLon(double lon) {
        this.Lon = lon;
    }

    public void setLat(double lat) {
        this.Lat = lat;
    }

    public void setMain(String main) {
        this.Main = main;
    }

    public void setSpeed(double speed) {
        this.Speed = speed;
    }

    public void setTemp(double temp) {
        this.Temp = temp;
    }

    public void setHumidity(int humidity) {
        this.Humidity = humidity;
    }
}
