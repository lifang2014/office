package com.common.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="t_sub_menu")
public class SubMenuEntity extends BaseEntity{

	private String name;//名称
	private String path;//访问路径
	private Boolean isSystem = false;
	
	public SubMenuEntity(){}
	
	public SubMenuEntity(String name, String path, Boolean isSystem){
		this.setName(name);
		this.setPath(path);
		this.setIsSystem(isSystem);
	}
	
	@Column(length=20,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=60,nullable=false)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}
	
}
