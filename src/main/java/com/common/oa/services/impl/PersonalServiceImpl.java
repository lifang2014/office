package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.PersonalEntity;
import com.common.oa.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/11/14.
 */
@Service
public class PersonalServiceImpl extends BaseServiceImpl<PersonalEntity,Long> implements PersonalService{

    @Override
    @Autowired
    public void setBaseDao(BaseDao<PersonalEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }
}
