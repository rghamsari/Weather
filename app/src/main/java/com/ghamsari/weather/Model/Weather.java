package com.ghamsari.weather.Model;

public class Weather {
    private double lon;
    private double lat;
    private String main;
    private double speed;
    private double temp;
    private int humidity;

    public Weather() {

    }

    public Weather(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String getMain() {
        return main;
    }

    public String getSpeed() {
        return speed +" km/hr";
    }

    public double getTemp() {
        return temp ;
    }

    public String getHumidity() {
        return humidity + " %";
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
