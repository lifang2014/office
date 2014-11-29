package com.common.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 登录日志实体类
 * Created by Jerry on 2014/11/28.
 */
@Entity
@Table(name = "t_login_log")
public class LoginLogEntity extends BaseEntity{

    private Date loginTime;//登录时间
    private String brower;//登录浏览器
    private String loginUserName;//登录名
    private String loginCompanyName;//登录公司名称
    private String loginIp;//登录IP
    private Integer status;//登录状态, 0 成功, 1失败
    private String remark;

    public LoginLogEntity() { }

    public LoginLogEntity(Date loginTime, String brower, String loginUserName,
                          String loginCompanyName, String loginIp, Integer status, String remark) {
        this.loginTime = loginTime;
        this.brower = brower;
        this.loginUserName = loginUserName;
        this.loginCompanyName = loginCompanyName;
        this.loginIp = loginIp;
        this.status = status;
        this.remark = remark;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Column(length = 100)
    public String getBrower() {
        return brower;
    }

    public void setBrower(String brower) {
        this.brower = brower;
    }

    @Column(length = 50)
    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    @Column(length = 50)
    public String getLoginCompanyName() {
        return loginCompanyName;
    }

    public void setLoginCompanyName(String loginCompanyName) {
        this.loginCompanyName = loginCompanyName;
    }

    @Column(length = 32)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(length = 20)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
