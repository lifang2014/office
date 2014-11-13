package com.common.oa.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 公司实体类
 * <pre>
 *     设计思路:
 *     1.公司实例下拥有多个组织(不直接关联，通过BaseEntity关联)
 *     2.组织下可以拥有多个岗位
 *     3.岗位下可以拥有多个职务
 * </pre>
 * @author jerry
 * 2014/08/13
 */

@Entity
@Table(name="t_company")
public class CompanyEntity extends BaseEntity {

	private String companyNo;//公司编号
	private String name;//公司名称
	private String fullName;//公司全称
	private String logo;//公司LOGO

	@Column(length = 20)
	@NotBlank
	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	@Column(length = 50)
	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 100)
	@NotBlank
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(length = 50)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
