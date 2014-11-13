package com.common.oa.utils;

import java.util.Objects;

/**
 * 当返回JSON数据给客户端时，需要包含一下数据
 * 1. errorCode 错误编码  0正确
 * 2. errorText 错误描述信息
 * 3. 具体数据,JSON格式
 * Created by Jerry on 2014/11/7.
 */
public class ResponseBody {

    public static final int SUCCESS = 0;

    private int errorCode;//错误编码

    private String errorText;//错误信息

    private Object data;//数据

    public ResponseBody(){};

    public ResponseBody(int errorCode, String errorText){
        this.setErrorCode(errorCode);
        this.setErrorText(errorText);
    }

    public ResponseBody(int errorCode, String errorText, Object data){
        this.setErrorCode(errorCode);
        this.setErrorText(errorText);
        this.setObject(data);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public Object getObject() {
        return data;
    }

    public void setObject(Object data) {
        this.data = data;
    }
}
