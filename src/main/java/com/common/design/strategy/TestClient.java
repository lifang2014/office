package com.common.design.strategy;

/**
 * Created by Administrator on 2014/11/17.
 */
public class TestClient {

    public static void main(String[] args){
        double bookPrice = 60.0D;
        MemberStrategy memberStrategy = new AdvancedMemberStrategy();
        Price price = new Price(memberStrategy);
        System.out.println("折扣后价格为:" + price.quote(bookPrice));
    }

}
