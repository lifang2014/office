package com.common.oa.method;

import com.common.oa.utils.DESUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 继承PropertyPlaceholderConfigurer,配置支持密文属性的属性文件
 * Created by Jerry on 2014/11/13.
 */
public class EncryptPropertyConfigurer extends PropertyPlaceholderConfigurer{

    private String[] encryptPropNames = {"jdbc.username","jdbc.password"};

    /**
     * 对特定属性的属性值进行转换
     * @param propertyName 属性名称
     * @param propertyValue 属性值
     * @return
     */
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        System.out.println("===========================================");
        System.out.println("===========================================");
        System.out.println("===========================================");
        if(isEncryptProp(propertyName)){
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            return decryptValue;
        }else{
            return propertyValue;
        }
    }

    /**
     * 判断属性是否需要解密
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName){
        for(String encryptPropName : encryptPropNames){
            if(StringUtils.equals(encryptPropName,propertyName)){
                return true;
            }
        }
        return false;
    }

}
