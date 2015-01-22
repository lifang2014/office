/**
 * Created by lifang on 2015/1/11.
 */
package com.common.design.factory.simple;

/*
    1.说明：
        简单工厂其实并不能算得上是一种设计模式，反而更像是一种编程习惯.

    2.实现：
        1. 定义一个Product接口
        2. 定义多个具体ProductA,ProductB...,继承Product接口
        3. 根据Client传入不同参，创建不同的Product.
    3.问题
        控制能生产固定的产品，需要有我指定生产Product.
        新增ProductFactory工厂类。由此工厂统一实现ProductA,ProductB....
 */