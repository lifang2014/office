package com.common.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.common.oa.entity.MenuEntity;
import com.common.oa.entity.SubMenuEntity;
import com.common.oa.services.MenuService;
import com.common.oa.utils.CommonUtils;
import com.common.oa.utils.JsonUtils;
import com.common.oa.utils.MessageUtils;
import com.common.oa.utils.SettingUtils;
import com.common.oa.vo.MenuVo;

/**
 * 功能菜单管理控制器
 * 
 * @author Jerry
 * @date 2014-4-30
 */
@Controller
@RequestMapping(value = "/admin/menu")
public class MenuController {

	Logger logger = Logger.getLogger(MenuController.class);

	private static final String M_PATH_MENU_BUILD = "/admin/menu/build";// 功能菜单列表
	private static final String M_PATH_MENU_EDIT = "/admin/menu/edit";// 编辑页面

	@Autowired
	private MenuService menuService;

	/**
	 * 菜单列表
	 * @return
	 */
	@RequestMapping(value = "/build", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.put("menus", menuService.findAll());
		return M_PATH_MENU_BUILD;
	}
	
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	@ResponseBody
	public String save(@Valid MenuVo menuVo,BindingResult binding,HttpServletResponse response){
		Integer error_code = 1000;
		String error_text = null;
		String content = null;
		if(binding.hasErrors()){
			error_code = 1001;
			error_text = binding.getFieldErrors().get(0).getDefaultMessage();
		}else{
			if(menuService.findByName(menuVo.getMenuName())==null){
				MenuEntity menu = new MenuEntity(menuVo.getMenuName(),Boolean.parseBoolean(menuVo.getSubMenuIsSystem()),Integer.valueOf(menuVo.getMenuRank()));
				List<SubMenuEntity> lists = new ArrayList<SubMenuEntity>();
				SubMenuEntity subMenu = new SubMenuEntity(menuVo.getSubMenuName(),
						menuVo.getSubMenuPath(),
						Boolean.parseBoolean(menuVo.getSubMenuIsSystem()));
				lists.add(subMenu);
				menu.setSubMenus(lists);
				menuService.persist(menu);
				long menu_id = menu.getId();
				long smallmenu_id = subMenu.getId();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("menu_id", menu_id);
				jsonObject.put("submenu_id", smallmenu_id);
				content = jsonObject.toJSONString();
				error_text = MessageUtils.getMessage("menu.tip.save.success");
			}else{
				error_code = 1002;
				error_text = MessageUtils.getMessage("menu.tip.name.exist");
			}
		}
		return JsonUtils.toStrMsg(error_code, error_text, content);
	}


	/**
	 * 菜单编辑
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Long menuId,ModelMap model){
		model.put("menu", menuService.findById(menuId));
		return M_PATH_MENU_EDIT;
	}
}
