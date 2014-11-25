package com.common.design.decorator;

import java.util.List;

/**
 * Created by Administrator on 2014/11/25.
 */
public abstract class DecoratorNews extends ComponentNews{

    /**
     * 获取新闻
     *
     * @return
     */
    @Override
    public List<Object> getListOfNews() {
        return componentNews.getListOfNews();
    }

    private ComponentNews componentNews;
    public DecoratorNews(ComponentNews componentNews) {
        this.componentNews = componentNews;
    }
}
