package com.common.oa.test.services;

import com.common.oa.entity.AdminEntity;
import com.common.oa.entity.IdentityEntity;
import com.common.oa.entity.OrganizationEntity;
import com.common.oa.services.IdentityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2014/11/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-db.xml"})
public class IdentityServiceTest extends BaseTest{

    @Autowired
    private IdentityService identityService;

    @Test
    public void getIdentity(){
        String no = identityService.getIdentity(1L, OrganizationEntity.class);
        logger.info("The identity is : {}", no);
    }

    @Test
    public void saveIdentity(){
        IdentityEntity identityEntity = new IdentityEntity();
        identityEntity.setValue(1000L);
        identityEntity.setKeyword("ABC");
        identityEntity.setCompanyId(1L);
        identityEntity.setClazz(OrganizationEntity.class.getName());
        identityEntity.setStep(5);
        identityService.persist(identityEntity);
    }
}
