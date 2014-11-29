package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.EmployeeEntity;
import com.common.oa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/11/10.
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeEntity,Long> implements EmployeeService{

    @Override
    @Autowired
    public void setBaseDao(BaseDao<EmployeeEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

}
