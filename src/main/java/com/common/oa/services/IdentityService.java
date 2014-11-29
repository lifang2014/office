package com.common.oa.services;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.IdentityEntity;

/**
 * Created by Jerry on 2014/11/26.
 */
public interface IdentityService extends BaseService<IdentityEntity,Long>{

    /**
     * 获取编号
     * @param companyId
     * @param clazz
     * @return
     */
    public String getIdentity(long companyId, Class clazz);

}
