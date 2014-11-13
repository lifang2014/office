package com.common.oa.dao.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.dao.EmployeeDao;
import com.common.oa.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2014/11/10.
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<EmployeeEntity,Long> implements EmployeeDao{
}
