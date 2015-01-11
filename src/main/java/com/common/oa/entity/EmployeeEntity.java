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

    private String employeeNo;//员工编号
    private String name;
    private Sex sex;
    private Date birthday;

    private String face;//头像
    private String tel;//电话
    private String email;//邮箱
    private String address;//工作地点
    private Date startDate;//入职日期
    private Date tonormalDate;//转正日期
    private Integer timeLimit;//适用期限
    private EmployeeTypeEntity employeeType;//员工状态
    private PersonalEntity personal = new PersonalEntity();//个人信息
    private OrganizationEntity organization;
//    private PositionEntity position;//岗位
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

//    @ManyToOne
//    @JoinColumn(name = "positionId")
//    public PositionEntity getPosition() {
//        return position;
//    }
//
//    public void setPosition(PositionEntity position) {
//        this.position = position;
//    }

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
    public PersonalEntity getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalEntity personal) {
        this.personal = personal;
    }

    @OneToOne
    @JoinColumn(name = "organizationId")
    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    public Date getTonormalDate() {
        return tonormalDate;
    }

    public void setTonormalDate(Date tonormalDate) {
        this.tonormalDate = tonormalDate;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Transient
    public String getSexText() {
        if(Sex.MALE == this.getSex()) {
            return "男";
        }else{
            return "女";
        }
    }

}
