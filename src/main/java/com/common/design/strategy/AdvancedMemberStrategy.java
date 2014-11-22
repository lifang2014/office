package com.common.design.strategy;

/**
 * 高级会员折扣算法
 * Created by Jerry on 2014/11/17.
 */
public class AdvancedMemberStrategy implements MemberStrategy{
    /**
     * 计算折扣后的价格
     *
     * @param price
     * @return
     */
    @Override
    public double calcPrice(double price) {
        //高级会员折扣为20%
        return price * 0.8;
    }
}
