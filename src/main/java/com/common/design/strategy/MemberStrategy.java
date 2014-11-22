package com.common.design.strategy;

/**
 * 会员折扣接口
 * Created by Administrator on 2014/11/17.
 */
public interface MemberStrategy {

    /**
     * 计算折扣后的价格
     * @return
     */
    public double calcPrice(double price);

}
