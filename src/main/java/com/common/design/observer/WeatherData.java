package com.common.design.observer;

import java.util.ArrayList;

/**
 * 观察者模式，主题具体现实类
 * Created by Administrator on 2014/11/22.
 */
public class WeatherData implements Subject{

    private ArrayList<Observer> observerArrayList = new ArrayList<Observer>();
    private String notifyText = null;

    /**
     * 注册成为观察者
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        this.observerArrayList.add(observer);
    }

    /**
     * 取消成为观察者
     *
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        int i = this.observerArrayList.indexOf(observer);
        if( i > 0 ){
            observerArrayList.remove(observer);
        }
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObservers() {
        for(int i = 0; i<observerArrayList.size(); i++){
            Observer observer = observerArrayList.get(i);
            observer.update(notifyText);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(String notifyText){
        this.notifyText = notifyText;
        measurementsChanged();
    }
}
