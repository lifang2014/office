package com.common.design.decorator;

import java.util.List;

/**
 * 从数据库中读取新闻
 * Created by Jerry on 2014/11/25.
 */
public class DatabaseNews extends ComponentNews{
    /**
     * 获取新闻
     *
     * @return
     */
    @Override
    public List<Object> getListOfNews() {
        System.out.println("===========从数据库中获取新闻列表==============");
        return null;
    }
}
