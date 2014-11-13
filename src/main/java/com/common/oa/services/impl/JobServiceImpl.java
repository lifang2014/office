package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.JobEntity;
import com.common.oa.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/11/7.
 */
@Service
public class JobServiceImpl extends BaseServiceImpl<JobEntity,Long> implements JobService{

    @Override
    @Autowired
    public void setBaseDao(BaseDao<JobEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
