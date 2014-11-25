package com.common.design.linked;

/**
 * 在List接口中，使用了Object，这样以来，会产生一个问题，不同的对象比较方式不一样
 * 所以，这里在定义一个比较策略，用户可以根据不同对象自定义比较策略.
 * Created by Jerry on 2014/11/23.
 */
public interface Strategy {

    /**
     * 比较两个元素是否相等
     * @param obj1
     * @param obj2
     * @return
     */
    public boolean equal(Object obj1, Object obj2);

    /**
     * 比较两个元素的大小
     * 1、如果obj1 < obj2 返回 -1
     * 2、如果0jb1 = obj2 放回 0
     * 3、如果obj2 > obj2 返回 1
     * @param obj1
     * @param obj2
     * @return
     */
    public int compare(Object obj1, Object obj2);

}
