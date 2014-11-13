package com.common.oa.test.services;

import com.alibaba.fastjson.JSON;
import com.common.oa.entity.CompanyEntity;
import com.common.oa.entity.JobEntity;
import com.common.oa.entity.OrganizationEntity;
import com.common.oa.entity.PositionEntity;
import com.common.oa.services.CompanyService;
import com.common.oa.services.JobService;
import com.common.oa.services.OrganizationService;
import com.common.oa.services.PositionService;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-db.xml"})
public class OrganizationServiceTest {

    private Logger logger = LoggerFactory.getLogger(OrganizationServiceTest.class);

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private JobService jobService;

    private static String[] orgNames = {"和平支行","绍兴支行","启动支行","嘉园支行","韶关支行","嘉兴支行"};
    private static String[] posNames = {"研发部","销售部","设计部","产品部","程序部","企划部","外交部"};
    private static String[] jobNames = {"程序员","产品经理","销售员","人事专员","架构师","分析师","美工"};

    /**
     * 测试数据
     * 保存组织信息
     */
    @Test
    public void testSaveOrg(){
        CompanyEntity company = companyService.getCompanyByNo("CP1000");
        List<OrganizationEntity> lstOrg = new ArrayList<OrganizationEntity>();
        Assert.assertNotNull(company);
        for(String name : orgNames) {
            OrganizationEntity org = new OrganizationEntity();
            org.setName(name);
            org.setCompanyId(company.getId());
            lstOrg.add(org);
        }
        organizationService.persistAll(lstOrg);
    }

    /**
     * 测试数据
     * 保存岗位信息
      */
    @Test
    public void testSavePosition(){
        CompanyEntity company = companyService.getCompanyByNo("CP1000");
        Assert.assertNotNull(company);
        for(String org : orgNames) {
            List<PositionEntity> lstPos = new ArrayList<PositionEntity>();
            OrganizationEntity organization = organizationService.findByName(org);
            Assert.assertNotNull(organization);
            for (String name : posNames) {
                PositionEntity pos = new PositionEntity();
                pos.setCompanyId(company.getId());
                pos.setOrganization(organization);
                pos.setName(name);
                lstPos.add(pos);
            }
            positionService.persistAll(lstPos);
        }
    }

    /**
     * 测试数据
     * 保存职务信息
     */
    @Test
    public void testSaveJob(){
        CompanyEntity company = companyService.getCompanyByNo("CP1000");
        Assert.assertNotNull(company);
        List<PositionEntity> positions = positionService.findAll();
        for(PositionEntity position : positions) {
            List<JobEntity> lstJobs = new ArrayList<JobEntity>();
            for(String name : jobNames) {
                JobEntity job = new JobEntity();
                job.setName(name);
                job.setCompanyId(company.getId());
                job.setPosition(position);
                lstJobs.add(job);
            }
            jobService.persistAll(lstJobs);
        }
    }

    @Test
    public void get(){
        CompanyEntity company = companyService.getCompanyByNo("CP1000");
        Assert.assertNotNull(company);
        List<OrganizationEntity> lstOrgs = organizationService.findAllByCompanyId(company.getId());
        logger.info("object to json:{}",lstOrgs.size());
        for(OrganizationEntity org : lstOrgs){
            System.out.println(JSON.toJSONString(org.getPositions()));
        }
    }
}
