package com.common.oa.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.oa.services.MenuService;

/**
 * 管理员管理控制器
 * <ol>
 *     <li>/admin/common/main	跳转到后台管理主页面</li>
 *     <li>/admin/common/error	报错页面</li>
 * </ol>
 * @author Jerry
 * @date 2014-04-30
 */
@Controller
@RequestMapping("/admin/common")
public class CommonController {
	
	private Logger logger = LoggerFactory.getLogger(CommonController.class);

	private static final String M_PATH_MAIN = "/admin/common/main";
	private static final String M_PATH_ERROR = "/admin/error/error";
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(ModelMap model){
		model.put("menus",menuService.findAll());
		return M_PATH_MAIN;
	}
	
	@RequestMapping(value="/error")
	public String error(){
		return M_PATH_ERROR;
	}
}
