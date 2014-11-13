package com.common.oa.controller;

import com.alibaba.fastjson.JSON;
import com.common.oa.entity.EmployeeEntity;
import com.common.oa.entity.OrganizationEntity;
import com.common.oa.services.CompanyService;
import com.common.oa.services.OrganizationService;
import com.common.oa.utils.ResponseUtils;
import freemarker.template.utility.SecurityUtilities;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <ol>
 *     <li>/admin/company/get 获取当前登录用户所属公司的组织架构</li>
 * </ol>
 * Created by Jerry on 2014/11/7.
 */
@Controller
@RequestMapping("/admin/company")
public class CompanyController {

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private OrganizationService organizationService;

    /**
     * 获取当前登录用户所属公司下的组织架构
     */
    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public String get(HttpSession session) {
        List<OrganizationEntity> lstOrganizations = organizationService.findAllByCompanyId(1L);
        return ResponseUtils.success(lstOrganizations);
    }

}
