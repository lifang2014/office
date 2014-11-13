package com.common.oa.filter;

import java.util.Date;


import com.common.oa.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.common.oa.entity.AdminEntity;
import com.common.oa.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationRealm extends AuthenticatingRealm{

	private Logger logger = LoggerFactory.getLogger(AuthenticationRealm.class);
	
	@Autowired
	private AdminService adminService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		String password = new String(token.getPassword());
		String ip = token.getHost();
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			AdminEntity admin = adminService.findByUsername(username);
			if(admin==null){
				throw new UnknownAccountException();
			}
			if(admin.getIsLocked()){
				throw new LockedAccountException();
			}
			String md5Hex = CommonUtils.getTime64MD5(password);
			if(CommonUtils.isMD5Equal(admin.getPassword(),md5Hex)){
				int loginFailureCount = admin.getLoginFailureCount() + 1;
				admin.setLoginFailureCount(loginFailureCount);
				adminService.update(admin);
				throw new IncorrectCredentialsException();
			}
			admin.setLoginDate(new Date());
			admin.setLoginIp(ip);
			admin.setLoginFailureCount(0);
			adminService.update(admin);
			logger.info("LOGIN USERNAME:{}",admin.getUsername());
			return new SimpleAuthenticationInfo(admin, password,getName());
		}
		throw new UnknownAccountException();
	}

}
