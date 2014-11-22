/**
 * Created by Administrator on 2014/11/17.
 */
package com.common.design.strategy;

/*
    策略模式
    用例说明:假设现在正在设计一个电子商务系统，有一种情况，高级会员可以享受20%的折扣，中级会员可以享受10%的折扣，
    而普通会员则不存在折扣。
    1. 高级会员   20%折扣
    2. 中级会员   10%折扣
    3. 普通会员   0折扣
    在本次需求上，需要考虑此三种情况(算法)，但作为一个有经验的码农，万一以后增加VIP会员呢，或者更多,咋办。。。。

    总结:
        策略模式的核心，不是如何去实现算法，而是如何去组织,调用这些算法，从何提高程序架构灵活性,具有更好的维护性和扩展性.
        优点:
            1.使用继承,可以把公共的代码移到父类,从而避免代码重复
            2.避免过多判断语句
        缺点:
            1.客户端必须确定算分或者行为的情况。
            2.策略模式把每一个策略都单独封装成一个类,如果策略过多,疯了，类爆炸了。。。。
 */