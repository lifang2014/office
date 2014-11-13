package com.common.oa.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by Jerry on 2014/11/7.
 */
public class ResponseUtils {

    public synchronized static String success(){
        ResponseBody body = new ResponseBody(ResponseBody.SUCCESS, "");
        return JSON.toJSONString(body);
    }

    public synchronized static String success(Object data){
        ResponseBody body = new ResponseBody(ResponseBody.SUCCESS, "", data);
        return JSON.toJSONString(body);
    }

    public synchronized static String error(int errorCode, String errorText){
        ResponseBody body = new ResponseBody(errorCode, errorText);
        return JSON.toJSONString(body);
    }
}
