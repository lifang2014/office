package com.common.design.factory;

/**
 * 口令认证算法
 * Created by Administrator on 2014/11/18.
 */
public class PasswordLogin implements ILogin{

    @Override
    public boolean verify(String username, String password) {
        //封装认证算法
        //.....
        return true;
    }
}
