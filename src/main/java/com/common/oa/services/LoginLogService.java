package com.common.oa.services;

import com.common.oa.entity.LoginLogEntity;

import java.util.Date;

/**
 * Created by Jerry on 2014/11/28.
 */
public interface LoginLogService extends BaseService<LoginLogEntity, Long>{

    /**
     * 保存登入日志
     * @param loginUserName
     * @param loginCompanyName
     * @param loginIp
     * @param status
     * @param brower
     */
    public void saveLoginLog(String loginUserName, String loginCompanyName,
                             String loginIp, Integer status,String brower, String remark);

}
