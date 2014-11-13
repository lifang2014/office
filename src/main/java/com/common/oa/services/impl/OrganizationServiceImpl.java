package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.dao.impl.BaseDaoImpl;
import com.common.oa.entity.MenuEntity;
import com.common.oa.entity.OrganizationEntity;
import com.common.oa.services.MenuService;
import com.common.oa.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/11/7.
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<OrganizationEntity, Long> implements OrganizationService {

    @Override
    @Autowired
    public void setBaseDao(BaseDao<OrganizationEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

}
