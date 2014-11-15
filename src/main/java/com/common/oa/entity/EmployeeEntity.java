package com.common.oa.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工信息表
 */
@Entity
@Table(name="t_employee")
public class EmployeeEntity extends BaseEntity {

    public enum Sex{MALE, FEMALE,SECRET} //性别枚举值
    public enum Politacal{GENERAL,MEMBER,PARTY,NONE,SECRET}//群众,党员,团员,无,保密

    private String employeeNo;//员工编号
    private String name;
    private Sex sex;
    private Date birthday;
    private String password;
    private boolean isLocked;//是否锁定

    private String face;//头像
    private String tel;//电话
    private String email;//邮箱
    private Politacal politacal;//政治面貌
    private String address;//工作地点
    private EmployeeTypeEntity employeeType;//员工状态
    private PersonalEntity personalInfo;//个人信息
    private OrganizationEntity organization;
    private PositionEntity position;//岗位
    private JobEntity job;//职务

    @Column(length = 20)
    @NotBlank
    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
    @Column(length = 50)
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 10)
    @Enumerated(EnumType.ORDINAL)
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @ManyToOne
    @JoinColumn(name = "positionId")
    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "jobId")
    public JobEntity getJob() {
        return job;
    }

    public void setJob(JobEntity job) {
        this.job = job;
    }

    @Column(length = 50)
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Column(length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.ORDINAL)
    public Politacal getPolitacal() {
        return politacal;
    }

    public void setPolitacal(Politacal politacal) {
        this.politacal = politacal;
    }

    @Column(length = 120)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @OneToOne
    @JoinColumn(name = "employeeTypeId")
    public EmployeeTypeEntity getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeTypeEntity employeeType) {
        this.employeeType = employeeType;
    }

    @OneToOne
    @JoinColumn(name = "personalId")
    public PersonalEntity getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalEntity personalInfo) {
        this.personalInfo = personalInfo;
    }

    @OneToOne
    @JoinColumn(name = "organizationId")
    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }
}
