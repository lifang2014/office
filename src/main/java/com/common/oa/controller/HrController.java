package com.common.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/build")
    public String build(){
        return M_PATH_BUILD;
    }

    @RequestMapping(value = "/action")
    public String action(){
        return M_PATH_ACTION;
    }

}
