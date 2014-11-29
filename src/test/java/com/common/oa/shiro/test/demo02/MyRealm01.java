package com.common.oa.shiro.test.demo02;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Administrator on 2014/11/28.
 */
public class MyRealm01 implements Realm{

    /**
     * 返回一个唯一的Realm名称
     * @return
     */
    @Override
    public String getName() {
        return "myRealm01";
    }

    /**
     * p判断此Realm是否支持Token
     * @param authenticationToken
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //此Realm仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    /**
     * 根据Token获取认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String username = (String)authenticationToken.getPrincipal();
        //获取密码
        String password = new String((char[])authenticationToken.getCredentials());

        if(!"zhang".equals(username)){
            throw new UnknownAccountException();
        }
        if(!"1234".equals(password)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
