package com.common.design.strategy;

/**
 * 初级会员折扣算法
 * Created by Jerry on 2014/11/17.
 */
public class PrimaryMemberStrategy implements MemberStrategy{

    /**
     * 计算折扣后的价格
     *
     * @return
     */
    @Override
    public double calcPrice(double price) {
        //初级会员不打折
        return price;
    }
}
