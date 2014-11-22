package com.common.design.factory;

/**
 * 域认证算法
 * Created by Administrator on 2014/11/18.
 */
public class DomainLogin implements ILogin{
    @Override
    public boolean verify(String username, String password) {
        //封装认证算法
        //.....
        return true;
    }
}
