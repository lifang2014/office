package com.common.oa.dao;

import com.common.oa.entity.CompanyEntity;

/**
 * Created by Administrator on 2014/11/6.
 */
public interface CompanyDao extends BaseDao<CompanyEntity, Long>{

    public CompanyEntity findCompanyByNo(String companyNo);

}
