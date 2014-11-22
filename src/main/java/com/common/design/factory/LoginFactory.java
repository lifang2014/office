package com.common.design.factory;

/**
 * 建立一个登录工程
 * Created by Administrator on 2014/11/18.
 */
public class LoginFactory {

    public static ILogin factory(String type){

        if("password".equals(type)){
            return new PasswordLogin();
        }else if("domain".equals(type)){
            return new DomainLogin();
        }else{
            throw new RuntimeException("没有找到的登录类型");
        }
    }

}
