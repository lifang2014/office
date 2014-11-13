package com.common.oa.exception;

/**
 * Created by Administrator on 2014/11/6.
 */
public class InitSystemException extends RuntimeException{

    /**
     * 自定义异常，初始化信息失败
     * @param message
     */
    public InitSystemException(String message) {
        super(message);
    }
}
