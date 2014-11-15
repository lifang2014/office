package com.common.oa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by Jerry on 2014/11/13.
 */
public class CollectionUtils {

    private Logger logger = LoggerFactory.getLogger(CollectionUtils.class);

    public abstract static class CollectionCompartor<T, S>{

        public abstract boolean equal(T t, S s);

    }

    /**
     * <T, S> 表示泛型方法,使用时指点类型
     * @param targets
     * @param sources
     * @param compartor
     * @param <T>
     * @param <S>
     * @return
     */
    public static synchronized <T,S> List<List<T>> refreshTargetsList(List<T> targets, List<S> sources, CollectionCompartor<T, S> compartor){
        List<List<T>> result = new LinkedList<List<T>>();
        for (T t : targets){
            boolean isExist = false;
            for(S s : sources){
                if(compartor.equal(t , s)){
                    isExist = true;
                    break;
                }
            }
            if(isExist){

            }
        }
        return null;
    }

}
