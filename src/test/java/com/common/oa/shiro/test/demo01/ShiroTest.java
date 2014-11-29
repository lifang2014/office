package com.common.oa.shiro.test.demo01;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Administrator on 2014/11/28.
 */
public class ShiroTest {

    @Test
    public void testShiroHelloWorld(){
        //获取SecurityManager工厂，此处使用ini配置文件初始化ScecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //得到SecurityManager实例,绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //得到Subject及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang","1234");

        //登录及身份验证
        subject.login(usernamePasswordToken);

        //断言是否登录成功
        Assert.assertEquals(true, subject.isAuthenticated());

        //退出
        subject.logout();

        //断言是否退出成功
        Assert.assertEquals(false, subject.isAuthenticated());
    }

}
