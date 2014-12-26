package com.common.oa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *
 * Created by Jerry on 2014/11/13.
 */
public class CollectionUtils {

    private Logger logger = LoggerFactory.getLogger(CollectionUtils.class);

    private static Integer INTEGER_ONE = new Integer(1);

    public abstract static class CollectionCompartor<T, S>{
        public abstract boolean equal(T t, S s);
    }

}
