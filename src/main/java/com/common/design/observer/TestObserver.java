package com.common.design.observer;

/**
 * 测试观察者模式
 * Created by Jerry on 2014/11/22.
 */
public class TestObserver {

    public static void main(String[] args){

        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        //主题发生改变
        weatherData.setMeasurements("hello world");
    }

}
