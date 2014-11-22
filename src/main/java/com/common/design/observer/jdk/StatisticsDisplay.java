package com.common.design.observer.jdk;

import com.common.design.observer.DisplayMethod;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2014/11/22.
 */
public class StatisticsDisplay implements Observer,DisplayMethod{

    private Observable observable;
    private String text;

    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("text:" + text);
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.text = weatherData.getNotifyText();
            display();
        }
    }
}
