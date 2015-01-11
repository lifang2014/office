package com.common.oa.test.services;

import com.common.oa.entity.*;
import com.common.oa.services.*;
import com.common.oa.utils.CommonUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-db.xml"})
public class HrServiceTest extends BaseTest{

    private Logger logger = LoggerFactory.getLogger(HrServiceTest.class);

    private static String[] empTypes = {"试用期","在职","离职","休假","停职","退休","自离"};
    private static String[] empNames = {"张三","李四","王五","赵柳","卓七","钱八"};

    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private JobService jobService;
    @Autowired
    private PersonalService personalService;

    public HrServiceTest() { }


    /**
     * 创建员工类型信息
     */
    @Test
    public void testSaveEmployeeType(){
        CompanyEntity company = companyService.getCompanyByNo("CP1000");
        List<EmployeeTypeEntity> lstEmpTypes = new ArrayList<EmployeeTypeEntity>();
        for(int i = 0; i < empTypes.length; i++){
            EmployeeTypeEntity employeeType = new EmployeeTypeEntity();
            employeeType.setName(empTypes[i]);
            employeeType.setSort(i);
            employeeType.setCompanyId(company.getId());
            lstEmpTypes.add(employeeType);
        }
        employeeTypeService.persistAll(lstEmpTypes);
    }

    @Test
    public void testDeleteEmployeeType(){
        List<EmployeeTypeEntity> lstEmployeeTypes = employeeTypeService.findAll();
        for(EmployeeTypeEntity employeeTypeEntity : lstEmployeeTypes){
            employeeTypeService.delete(employeeTypeEntity.getId());
        }
        logger.info("DELETE EMPLOYEE TYPE SUCCESSED");
    }

    @Test
    public void testSaveEmployee(){
        List<EmployeeEntity> lstEmployees = new ArrayList<EmployeeEntity>();
        CompanyEntity company = companyService.getCompanyByNo("CP1000");
        Assert.assertNotNull(company);
        EmployeeTypeEntity employeeTypeEntity = employeeTypeService.findById(361L);
        Assert.assertNotNull(employeeTypeEntity);
        OrganizationEntity organizationEntity = organizationService.findById(18L);
        Assert.assertNotNull(organizationEntity);
        PositionEntity positionEntity = positionService.findById(25L);
        Assert.assertNotNull(positionEntity);
        JobEntity jobEntity = jobService.findById(66L);
        for(int i = 0; i < empNames.length; i++) {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setCompanyId(company.getId());
            employeeEntity.setName(empNames[i]);
            employeeEntity.setAddress("上海虹口足球场");
            employeeEntity.setEmail("test@qq.com");
            employeeEntity.setFace("defalt.png");
            employeeEntity.setBirthday(new Date());
            employeeEntity.setTel("15918761342");
            employeeEntity.setSex(EmployeeEntity.Sex.FEMALE);
            employeeEntity.setEmployeeType(employeeTypeEntity);
            employeeEntity.setOrganization(organizationEntity);
//            employeeEntity.setPosition(positionEntity);
            employeeEntity.setJob(jobEntity);
            lstEmployees.add(employeeEntity);
        }
        employeeService.persistAll(lstEmployees);
        logger.info("SAVE EMPLOYEE SUCCESSED");
    }

    /**
     * 删除用户
     */
    @Test
    public void testDeleteEmployee(){
        List<EmployeeEntity> lstEmployees = employeeService.findAll();
        for(EmployeeEntity employeeEntity : lstEmployees){
            employeeService.delete(employeeEntity.getId());
        }
    }

    /**
     * 保存用户个人信息
     */
    @Test
    public void testSavePersonal(){
        List<EmployeeEntity> lstEmployees = employeeService.findAll();
        for(EmployeeEntity employee : lstEmployees) {
            PersonalEntity personal = new PersonalEntity();
            CompanyEntity company = companyService.getCompanyByNo("CP1000");
            Assert.assertNotNull(company);
            personal.setCompanyId(company.getId());
            personal.setAlias("李四");
            personal.setHomeAddress("江西南昌");
//        personal.setContacts();
//        personal.setFamilys();
            personal.setHeight(170F);
            personal.setWeight(56F);
//            personal.setEmployee(employee);
            personal.setIdCard("72472942432424234676");
            personal.setIdCardValid(new Date());
            personal.setPhyle("汉族");
            personal.setPolitacal(PersonalEntity.Politacal.GENERAL);
            personal.setMarriage(PersonalEntity.Marriage.UNMARRIED);
            personal.setPassport("345665755644");
            personal.setHomeAddress("江西省赣州市南康区潭口镇XXX号XXX小区");
            personal.setPassportValid(new Date());
            personalService.persist(personal);
        }
    }


    @Test
    public void testDeletePersonal(){
        List<PersonalEntity> lstPersonals = personalService.findAll();
        for(PersonalEntity personal : lstPersonals){
            personalService.delete(personal.getId());
        }
    }
}
