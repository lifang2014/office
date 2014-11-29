package com.common.oa.controller;

import com.common.design.observer.Subject;
import com.common.oa.entity.AdminEntity;
import com.common.oa.services.AdminService;
import com.common.oa.services.EmployeeTypeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * <ol>
 *     <li>/admin/hr/build 跳转到信息中心页面</li>
 *     <li>/admin/hr/action 跳转到人事活动页面</li>
 * </ol>
 * Created by Jerry on 2014/11/6.
 */
@Controller
@RequestMapping("/admin/hr")
public class HrController {

    private static final String M_PATH_BUILD = "/admin/hr/build";
    private static final String M_PATH_ACTION = "/admin/hr/action";

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @RequestMapping(value = "/build")
    public String build(ModelMap model){
        AdminEntity adminEntity = adminService.getCurrentUser();
        model.put("employee", adminEntity.getEmployeeEntity());
        model.put("employeeTypes", employeeTypeService.findAllByCompanyId(adminEntity.getCompanyId()));
        return M_PATH_BUILD;
    }

    @RequestMapping(value = "/action")
    public String action(){
        return M_PATH_ACTION;
    }

}
