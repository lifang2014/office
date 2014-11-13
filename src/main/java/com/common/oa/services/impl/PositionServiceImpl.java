package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.PositionEntity;
import com.common.oa.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/11/7.
 */
@Service
public class PositionServiceImpl extends BaseServiceImpl<PositionEntity,Long> implements PositionService{

    @Override
    @Autowired
    public void setBaseDao(BaseDao<PositionEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
