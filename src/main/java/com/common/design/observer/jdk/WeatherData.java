package com.common.design.observer.jdk;

import java.util.Observable;

/**
 * 观察者模式，使用JDK自带接口实现
 * Created by Jerry on 2014/11/22.
 */
public class WeatherData extends Observable{

    private String notifyText;

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(String notifyText){
        this.notifyText = notifyText;
        measurementsChanged();
    }

    public String getNotifyText() {
        return notifyText;
    }

}
