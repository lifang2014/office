package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.dao.LoginLogDao;
import com.common.oa.entity.LoginLogEntity;
import com.common.oa.services.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Jerry on 2014/11/28.
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLogEntity,Long> implements LoginLogService{

    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<LoginLogEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 保存登入日志
     *
     * @param loginUserName
     * @param loginCompanyName
     * @param loginIp
     * @param status
     * @param brower
     */
    @Override
    @Transactional
    public void saveLoginLog(String loginUserName, String loginCompanyName,
                             String loginIp, Integer status, String brower, String remark) {
        LoginLogEntity loginLogEntity = new LoginLogEntity(
                new Date(),
                brower,
                loginUserName,
                loginCompanyName,
                loginIp,
                status,
                remark);
        loginLogDao.persist(loginLogEntity);
    }
}
