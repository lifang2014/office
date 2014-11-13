package com.common.oa.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class MenuVo {

	@NotNull(message="{menu.tip.name.not.null}")
	private String menuName;
	
	private String menuIsSystem;
	
	@Pattern(message="{menu.tip.rank.not.num}",regexp="^[0-9]*$")
	private String menuRank ;
	
	@NotNull(message="{menu.tip.name.not.null}")
	private String subMenuName;
	
	@NotNull(message="{menu.tip.path.not.null}")
	private String subMenuPath;
	
	private String subMenuIsSystem;
	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuIsSystem() {
		return menuIsSystem;
	}


	public void setMenuIsSystem(String menuIsSystem) {
		this.menuIsSystem = menuIsSystem;
	}


	public String getMenuRank() {
		return menuRank;
	}


	public void setMenuRank(String menuRank) {
		this.menuRank = menuRank;
	}


	public String getSubMenuName() {
		return subMenuName;
	}


	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}


	public String getSubMenuPath() {
		return subMenuPath;
	}


	public void setSubMenuPath(String subMenuPath) {
		this.subMenuPath = subMenuPath;
	}


	public String getSubMenuIsSystem() {
		return subMenuIsSystem;
	}


	public void setSubMenuIsSystem(String subMenuIsSystem) {
		this.subMenuIsSystem = subMenuIsSystem;
	}


	@Override
	public String toString() {
		return "MenuVo: [menuName:" + menuName + ",menuRank:" + menuRank + ",menuIsEnabled" + menuIsSystem 
				+ ",subMenuName:" + subMenuName + ",subMenuPath:" + subMenuPath + ",subMenuIsEnabled:" + subMenuIsSystem + "]";
	}
	
}
