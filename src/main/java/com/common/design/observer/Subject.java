package com.common.design.observer;

/**
 * 观察者模式，主题接口
 * Created by Jerry on 2014/11/22.
 */
public interface Subject{

    /**
     * 注册成为观察者
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 取消成为观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyObservers();
}
