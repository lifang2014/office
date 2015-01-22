package com.common.design.factory.simple;

/**
 * Created by lifang on 2015/1/11.
 */
public class FoodProduct implements Product{

    @Override
    public void sell() {
        System.out.println("贩卖食品.....");
    }
}
