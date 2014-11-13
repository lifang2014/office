package com.common.oa.utils;

import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Multiset.Entry;

/**
 * JSON格式处理
 * @author jerry
 * 2014/08/08
 */

public class JsonUtils {

	/**
	 * 把服务端信息转化为JSON返回给客户端
	 * @param error_code 错误编码
	 * @param error_text 错误信息
	 * @return
	 */
	public static String toStrMsg(Integer error_code,String error_text,String content){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("error_code", error_code);
		jsonObject.put("error_text", error_text);
		jsonObject.put("content", content);
		return jsonObject.toJSONString();
	}
	

}
