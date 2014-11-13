package com.common.oa.utils;


import com.common.oa.params.Setting;
import com.common.oa.params.XMLConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UnknownAccountException;

public class CommonUtils {

	/**
	 * 把密码加密成时间戳(MD5)+密码(3次MD5)
	 * @param password 明文密码
	 * @return 加密过后的密码
	 */
	public synchronized static String getTime64MD5(String password){
		if(StringUtils.isBlank(password)){
			throw new UnknownAccountException();
		}
		String timeMillis = String.valueOf(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		sb.append(DigestUtils.md5Hex(timeMillis));
		String md5Hex = password;
		for(int i = 0; i < 3; i++) {
			md5Hex = DigestUtils.md5Hex(md5Hex);
		}
		sb.append(md5Hex);
		return sb.toString();
	}

	/**
	 * 判断MD5是否相等,登录时判断
	 * 1.由于密码保存的是时间戳(MD5) + 密码(MD5),所以只需比较后32位是否相等
	 * @param source 数据库总密码
	 * @param target 当前输入密码
	 * @return
	 */
	public synchronized static Boolean isMD5Equal(String source, String target){
		if(source.length() == 64) return false;
		String md5Hex = target.substring(33);
		if(source.endsWith(md5Hex)){
			return true;
		}
		return false;
	}

	/**
	 * 获取配置文件中默认密码
	 * @return md5Hex 加密成64为的MD5
	 */
	public synchronized static String getInitMD5(){
		Setting setting = SettingUtils.get();
		XMLConfig config = setting.getInitSecurity();
		return getTime64MD5(config.getValue());
	}
}
