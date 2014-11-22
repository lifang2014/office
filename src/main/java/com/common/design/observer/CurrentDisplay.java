package com.common.design.observer;

/**
 * 观察者模式，定义一个观察者
 * Created by Administrator on 2014/11/22.
 */
public class CurrentDisplay implements Observer,DisplayMethod{

    private String text;

    private Subject subject;

    public CurrentDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("notity text:" + text);
    }

    @Override
    public void update(String notityText) {
        this.text = notityText;
        display();
    }
}
