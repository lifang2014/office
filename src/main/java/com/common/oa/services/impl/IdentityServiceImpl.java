package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.dao.IdentityDao;
import com.common.oa.entity.IdentityEntity;
import com.common.oa.services.IdentityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/11/26.
 */
@Service
public class IdentityServiceImpl extends BaseServiceImpl<IdentityEntity,Long> implements IdentityService{

    @Autowired
    private IdentityDao identityDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<IdentityEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 获取编号
     * @param companyId
     * @param clazz
     * @return
     */
    @Override
    public String getIdentity(long companyId, Class clazz) {
        if(!(StringUtils.isBlank(companyId + "") || clazz == null)){
            IdentityEntity identityEntity = identityDao.findIdentityEntity(companyId, clazz.getName());
            if(identityEntity != null){
                String key = identityEntity.getKeyword();
                Long value = identityEntity.getValue();
                int step = identityEntity.getStep();
                Long next = value + step;
                identityEntity.setValue(next);
                return new StringBuilder(key).append(value).toString();
            }
        }
        return null;
    }
}
