package com.common.oa.services;

import com.common.oa.entity.CompanyEntity;

/**
 * Created by Administrator on 2014/11/6.
 */
public interface CompanyService extends  BaseService<CompanyEntity, Long>{

    public CompanyEntity getCompanyByNo(String companyNo);

}
