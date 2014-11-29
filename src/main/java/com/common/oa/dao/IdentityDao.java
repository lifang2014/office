package com.common.oa.dao;

import com.common.oa.entity.IdentityEntity;

/**
 * Created by Jerry on 2014/11/26.
 */
public interface IdentityDao extends BaseDao<IdentityEntity, Long>{

    public IdentityEntity findIdentityEntity(long companyId, String clazz);

}
