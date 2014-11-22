package com.common.design.observer.jdk;

/**
 * Created by Administrator on 2014/11/22.
 */
public class TestObserver2 {

    public static void main(String[] args){

        WeatherData weatherData = new WeatherData();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements("hello lishiming");
        weatherData.setMeasurements("write the code,change the world");
    }
}
