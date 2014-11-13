package com.common.oa.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SubMenuVo {

	private int menuId;
	private String subMenuName;
	private String subMenuPath;
	private String subMenuIsSystem;
	
	@NotNull(message="{common.system.exception}")
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	@NotNull(message="{menu.tip.name.not.null}")
	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	@NotNull(message="{menu.tip.path.not.null}")
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
}
