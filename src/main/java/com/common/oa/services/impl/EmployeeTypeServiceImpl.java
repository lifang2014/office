package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.EmployeeTypeEntity;
import com.common.oa.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/11/10.
 */
@Service
public class EmployeeTypeServiceImpl extends BaseServiceImpl<EmployeeTypeEntity,Long> implements EmployeeTypeService{

    @Override
    @Autowired
    public void setBaseDao(BaseDao<EmployeeTypeEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
