package com.common.design.strategy;

/**
 * Created by Jerry on 2014/11/17.
 */
public class Price {

    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy){
        this.memberStrategy = memberStrategy;
    }

    public double quote(double price){
        return this.memberStrategy.calcPrice(price);
    }

}
