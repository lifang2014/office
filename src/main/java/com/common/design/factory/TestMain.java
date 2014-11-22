package com.common.design.factory;

/**
 * Created by Administrator on 2014/11/18.
 */
public class TestMain {

    public static void main(String[] args){
        ILogin login = LoginFactory.factory("password");
        login.verify("root","123456");
    }

}
