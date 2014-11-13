package com.common.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;






import com.alibaba.fastjson.JSONObject;
import com.common.oa.entity.MenuEntity;
import com.common.oa.entity.SubMenuEntity;
import com.common.oa.services.MenuService;
import com.common.oa.services.SubMenuService;
import com.common.oa.utils.CommonUtils;
import com.common.oa.utils.JsonUtils;
import com.common.oa.utils.MessageUtils;
import com.common.oa.utils.SettingUtils;
import com.common.oa.vo.SubMenuVo;


@Controller("subMenuController")
@RequestMapping("/admin/submenu")
public class SubMenuController  {
	
	private Logger logger = Logger.getLogger(SubMenuController.class);
	
	@Autowired
	public MenuService menuService;
	@Autowired
	private SubMenuService subMeauService;

	/**
	 * 更新子菜单
	 * @param name
	 * @param path
	 * @param id
	 * @param response
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(String name,String path,String check,Long id,HttpServletResponse response){

	}
	
	/**
	 * 删除子菜单
	 * @param response
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Long subMenuId,HttpServletResponse response){
		logger.info("删除子菜单...");
		Integer error_code = 1000;
		String error_text = MessageUtils.getMessage("common.system.exception");
		SubMenuEntity subMenu = subMeauService.findById(subMenuId);
		if(subMenu != null){
			if(subMenu.getIsSystem()){
				error_code = 1002;
				error_text = MessageUtils.getMessage("common.issystem.data");
			}else{
				subMeauService.delete(subMenuId);
				error_text = MessageUtils.getMessage("common.delete.success");
			}
		}
		return JsonUtils.toStrMsg(error_code, error_text, "");
	}
	
	/**
	 * 保存子菜单
	 * @param response
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String save(@Valid SubMenuVo subMenuVo,BindingResult binding,HttpServletResponse response){
		logger.info("保存子菜单...");
		Integer error_code = 1000;
		String error_text = null;
		String content = null;
		if(binding.hasErrors()){
			error_code = 1001;
			error_text = binding.getFieldErrors().get(0).getDefaultMessage();
		}else{
			if(subMeauService.findByName(subMenuVo.getSubMenuName())!=null){
				error_code = 1002;
				error_text = MessageUtils.getMessage("menu.tip.name.exist");
			}else{
				MenuEntity menu = menuService.findById(Long.valueOf(subMenuVo.getMenuId()));
				if(menu==null){
					error_code = 1003;
					error_text = MessageUtils.getMessage("common.system.exception");
				}else{
					List<SubMenuEntity> lists = menu.getSubMenus();
					SubMenuEntity submenu = new SubMenuEntity();
					submenu.setName(subMenuVo.getSubMenuName());
					submenu.setPath(subMenuVo.getSubMenuPath());
					submenu.setIsSystem(Boolean.valueOf(subMenuVo.getSubMenuIsSystem()));
					lists.add(submenu);
					menu.setSubMenus(lists);
					menuService.update(menu);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("submenu_id", submenu.getId());
					content = jsonObject.toJSONString();
				}
			}
		}
		return JsonUtils.toStrMsg(error_code, error_text, content);
	}
	
}
