package com.common.design.strategy;

/**
 * 中级会员折扣算法类
 * Created by Jerry on 2014/11/17.
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    /**
     * 计算折扣后的价格
     *
     * @param price
     * @return
     */
    @Override
    public double calcPrice(double price) {
        //中级会员折扣为10%
        return price * 0.9;
    }
}
