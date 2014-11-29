package com.common.oa.entity;


import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="t_admin")
public class AdminEntity extends BaseEntity{

	private String username;//用户名
	private String email;//Email登录
	private String password;//密码
	private Boolean isLocked;//是否锁定
	private Date loginDate;//登录日期
	private Date lockedDate;//锁定日期
	private String loginIp;//登录IP
	private Integer loginFailureCount;//登录失败次数

	private EmployeeEntity employeeEntity;

	@Column(length=16,unique=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 64)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	@Column(length = 32)
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
}
