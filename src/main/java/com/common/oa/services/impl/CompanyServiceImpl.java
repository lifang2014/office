package com.common.oa.services.impl;

import com.common.oa.dao.BaseDao;
import com.common.oa.dao.CompanyDao;
import com.common.oa.entity.CompanyEntity;
import com.common.oa.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2014/11/6.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyEntity,Long> implements CompanyService{

    @Autowired
    private CompanyDao companyDao;

    @Override
    @Autowired
    public void setBaseDao(BaseDao<CompanyEntity, Long> baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyEntity getCompanyByNo(String companyNo) {
        return companyDao.findCompanyByNo(companyNo);
    }
}
