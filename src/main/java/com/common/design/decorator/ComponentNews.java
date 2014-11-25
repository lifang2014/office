package com.common.design.decorator;

import java.util.List;

/**
 * 定义根据不同载体读取新闻的抽象类
 * Created by Jerry on 2014/11/25.
 */
public abstract class ComponentNews {

    /**
     * 获取新闻
     * @return
     */
    public abstract List<Object> getListOfNews();

}
