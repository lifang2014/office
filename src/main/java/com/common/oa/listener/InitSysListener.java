package com.common.oa.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.common.oa.entity.CompanyEntity;
import com.common.oa.exception.InitSystemException;
import com.common.oa.services.CompanyService;
import com.common.oa.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.common.oa.entity.AdminEntity;
import com.common.oa.entity.MenuEntity;
import com.common.oa.entity.SubMenuEntity;
import com.common.oa.params.Setting;
import com.common.oa.params.XMLConfig;
import com.common.oa.services.AdminService;
import com.common.oa.services.MenuService;
import com.common.oa.services.SubMenuService;
import com.common.oa.utils.SettingUtils;

/**
 * Spring容器启动后执行,初始化信息
 * @author jerry
 * 2014/08/27
 */

@Component
public class InitSysListener implements ApplicationListener<ContextRefreshedEvent>{
	
	private Logger logger = LoggerFactory.getLogger(InitSysListener.class);

	@Autowired
	private AdminService adminService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private SubMenuService subMenuService;
	@Autowired
	private CompanyService companyService;

	private static String splitSymbol = "";

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			Setting setting = SettingUtils.get();
			boolean boolInit = getBoolInit(setting);
			if(boolInit) {
				splitSymbol = getSplitSymbol(setting);
				if(StringUtils.isNotBlank(splitSymbol)) {
					initCompany(setting);
					initAdmin(setting);
					initMenu(setting);
				}
			}
		}
	}

	/**
	 * 获取是否开启初始化功能
	 * @param setting
	 * @return
	 */
	private boolean getBoolInit(Setting setting){
		XMLConfig config = setting.getBoolInit();
		logger.info("Whether to enable the initialization:{}",config.isEnabled());
		return config.isEnabled();
	}

	/**
	 * 获取XML内容分隔符
	 * @param setting
	 */
	private String getSplitSymbol(Setting setting){
		XMLConfig config = setting.getSplit();
		logger.info("GET XML SPLIT SYMBOL:{}",config.isEnabled());
		if(config.isEnabled()){
			return StringUtils.trim(config.getValue());
		}
		return null;
	}

	private void initCompany(Setting setting){
		XMLConfig config = setting.getCompany();
		logger.info("INIT COMPANY:{}", config.isEnabled());
		if(config.isEnabled()){
			for(Map<String,String> map : config.getLists()){
				for(Map.Entry<String, String> entry : map.entrySet()){
					String companyNo = entry.getKey();
					String[] values = entry.getValue().split(splitSymbol);
					CompanyEntity company = companyService.getCompanyByNo(companyNo);
					if(company == null){
						company = new CompanyEntity();
					}
					company.setCompanyNo(companyNo);
					company.setName(values[0]);
					company.setFullName(values[1]);
					company.setLogo(values[2]);
					companyService.merge(company);
				}
			}
		}
	}

	/**
	 * 初始化管理员信息
	 */
	private void initAdmin(Setting setting){
		XMLConfig config = setting.getAdmin();
		logger.info("INIT SYSTEM:{}", config.isEnabled());
		if(config.isEnabled()){
			for(Map<String,String> map : config.getLists()){
				for(Map.Entry<String, String> entry : map.entrySet()){
					AdminEntity admin = adminService.findByUsername(entry.getKey());
					String[] values = entry.getValue().split(splitSymbol);
					String password = values[0];
					String companyNo = values[1];
					CompanyEntity company = companyService.getCompanyByNo(companyNo);
					if(company == null){
						logger.debug("Initialization information failed");
						throw new InitSystemException("Initialization information failed");
					}
					if(admin==null){
						admin = new AdminEntity();
					}
					admin.setEmail("--");
					admin.setPassword(CommonUtils.getTime64MD5(password));
					admin.setCompanyId(company.getId());
					admin.setUsername(entry.getKey().trim());
					admin.setIsLocked(false);
					adminService.merge(admin);
				}
			}
		}
	}
	
	/**
	 * 初始化菜单
	 * @param setting
	 */
	private void initMenu(Setting setting){
		XMLConfig config = setting.getMenu();
		logger.info("INIT SYSTEM MENU:{}", config.isEnabled());
		if(config.isEnabled()){
			for(Map<String,String> map : config.getLists()){
				for(Map.Entry<String, String> entry : map.entrySet()){
					MenuEntity menu = menuService.findByName(entry.getKey());
					String value = entry.getValue();
					String[] sub = value.split(splitSymbol);
					if(menu==null){
						List<SubMenuEntity> subMenus = new ArrayList<SubMenuEntity>();
						menu = new MenuEntity();
						menu.setIsSystem(true);
						menu.setName(entry.getKey());
						menu.setRank(1);
						SubMenuEntity sm = new SubMenuEntity();
						sm.setName(sub[0].trim());
						sm.setIsSystem(true);
						sm.setPath(getPathSubfix(sub[1], setting));
						subMenus.add(sm);
						menu.setSubMenus(subMenus);
						menuService.persist(menu);
					}else{
						SubMenuEntity subMenu = subMenuService.findByName(sub[0]);
						if(subMenu==null){
							SubMenuEntity sm = new SubMenuEntity();
							sm.setIsSystem(true);
							sm.setName(sub[0]);
							sm.setPath(getPathSubfix(sub[1], setting));
							menu.getSubMenus().add(sm);
							menuService.update(menu);
						}
					}
				}
			}
		}
	}

	/**
	 * 获取文件后缀
	 * @param path
	 * @param setting
	 * @return
	 */
	private String getPathSubfix(String path,Setting setting){
		XMLConfig config = setting.getSubfix();
		if(config.isEnabled()){
			if(!path.endsWith(config.getValue())){
				return StringUtils.trim(path) + config.getValue();
			}
		}
		return StringUtils.trim(path);
	}
}
