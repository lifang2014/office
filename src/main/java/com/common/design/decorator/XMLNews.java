package com.common.design.decorator;

import java.util.List;

/**
 * 读取XML中新闻信息
 * Created by Jerry on 2014/11/25.
 */
public class XMLNews extends ComponentNews{
    /**
     * 获取新闻
     *
     * @return
     */
    @Override
    public List<Object> getListOfNews() {
        System.out.println("===========从XML中获取新闻列表==============");
        return null;
    }
}
