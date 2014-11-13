package com.common.oa.filter;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;

/**
 * JSON过滤器,驼峰标识改为下划线分割
 * @author jerry
 * @since 2014/8/11
 */
public class JsonFormatFilter implements PropertyFilter, NameFilter  {
	
    private static Logger logger = LoggerFactory.getLogger(JsonFormatFilter.class);
    
    protected String excludeObjectNames[] = null;

    public JsonFormatFilter() { }

    /**
     * 传入需要过滤的类和属性
     * @param inputFilterPropertyNames
     */
    public JsonFormatFilter(String inputFilterPropertyNames){
        if(inputFilterPropertyNames == null) return;
        excludeObjectNames = inputFilterPropertyNames.split(";");
    }

    /**
     * 过滤延迟加载等不需要被序列化的属性，主要是应用于Hibernate的代理和管理。
     * @param object 属性所在的对象
     * @param name 属性名
     * @param value 属性值
     * @return 返回false属性将被忽略，ture属性将被保留
     */
    public boolean apply(Object object, String name, Object value) {
        if(isMatchExcludeObjectAndName(object, name))
            return false;

//        if (value instanceof HibernateProxy) {//hibernate代理对象
//            LazyInitializer initializer = ((HibernateProxy) value).getHibernateLazyInitializer();
//            if (initializer.isUninitialized()) {
//                return false;
//            }
//        } else if (value instanceof PersistentCollection) {//实体关联集合一对多等
//            PersistentCollection collection = (PersistentCollection) value;
//            if (!collection.wasInitialized()) {
//                return false;
//            }
//            Object val = collection.getValue();
//            if (val == null) {
//                return false;
//            }
//        }
        return true;
    }



    /**
     *  驼峰格式字符串 转换成 下划线格式字符串
     * @param object 属性所在的对象
     * @param name 属性名，驼峰格式字符串
     * @param value 属性值
     * @return 下划线格式字符串
     */
    public String process(Object object, String name, Object value){
    	//因为此方法把map的key的值修改掉，所以提取出来，直接返回
    	if((object.getClass()==HashMap.class) || (object.getClass()==TreeMap.class)){
    		return name;
    	}
        Pattern p = Pattern.compile("[A-Z]");
        if (name == null || name.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(name);
        Matcher mc = p.matcher(name);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i,mc.end() + i,"_" + mc.group().toLowerCase());
            i++;
        }
        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    protected boolean isMatchExcludeObjectAndName(Object object, String name) {
        //先判断是否有不需要转换的属性
        if (excludeObjectNames != null) {
            //有需要额外判断的
            for (String propertyName : excludeObjectNames) {
                //如果是空的，那就跳过继续找下面的
                if (StringUtils.isBlank(propertyName)) {
                    continue;
                }
                if (propertyName.indexOf(".") > 0) {
                    //带有class名字了
                    String s[] = propertyName.split("\\.");
                    if (object.getClass().toString().endsWith(s[0]) && name.startsWith(s[1])) {
                        logger.debug("matching !!!!!!!");
                        return true;
                    }
                } else {
                    //仅仅是属性名字
                    if (name.startsWith(propertyName)) {
                        logger.debug("matching !!!!!!!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

}