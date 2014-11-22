/**
 * Created by Jerry on 2014/11/22.
 */
package com.common.design.observer;

/*
    观察者模式：
    1.定义：观察者模式定义了对象之间一对多的依赖，当一个对象改变状态时，它所有的依赖都会收到
    通知并做出响应。通常一的一方称为主题Subject,多的一方称为观察者Observer.
    2.实例： 出版者 + 订阅者 = 观察者模式
        2.1 在生活中，订阅者向出版者订阅报纸，出版者每天只要有新的报纸更新，就会自动派送给订阅者。这里的订阅者充当
        观察者模式中的观察者，出版者为主题，主题一般是掌握数据的一方。
    3.实现：
        3.1 首先需要定义一个Subject接口,一般拥有以下三个方法：
            3.1.1 registerObserver() 注册成为观察者
            3.1.2 removeObserver() 取消称为观察者
            3.1.3 notifyObservers() 通知所有观察者
        3.2 然后需要有一个订阅者接口Observer，这个接口通常是定义观察者在接收到主题的通知需要做出的响应,如更新。
            3.1.1 update() 接收到主题通知后，做出更新动作。
        3.3 其次，需要定义主题和观察者的具体实现类。
    4.总结：
        4.1 观察者模式提供了一种对象设计，让主题和观察者之间松耦合。

 */