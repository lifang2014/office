package com.common.oa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity(name="t_menu")
public class MenuEntity extends BaseEntity{

	private String name;//名称
	private List<SubMenuEntity> subMenus = new ArrayList<SubMenuEntity>();
	private Integer rank = 0;//序号
	private Boolean isSystem = false;//是否系统内置
	
	public MenuEntity(){}
	
	public MenuEntity(String name, boolean isSystem, Integer rank){
		this.setName(name);
		this.setIsSystem(isSystem);
		this.setRank(rank);
	}
	
	@Column(length=20,unique=true,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="menu_id")
	public List<SubMenuEntity> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<SubMenuEntity> subMenus) {
		this.subMenus = subMenus;
	}
	@OrderBy
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Boolean getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}
	
}
