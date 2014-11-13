package com.common.oa.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 个人信息实体类
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_personal_info")
public class PersonalInfoEntity extends BaseEntity{

    enum Marriage{UNMARRIED,MARRIED,REMARRIAGE,DIVORCE,WIDOWED,SECRET}//未婚,已婚,再婚,离异,丧偶,保密

    private String nativePlace;//籍贯
    private String beforeName;//曾用名
    private String idCard;//身份证
    private Date idCardValid;//有效期
    private String passport;//护照
    private Date passportValid;//护照有效期
    private Marriage marriage;//婚姻状况
    private String phyle;//民族
    private String homePhone;//家庭电话
    private String homeAddress;//家庭地址
    private Float height;//身高
    private Float weight;//体重
    private List<ContactEntity> contacts;//紧急联系人
    private List<FamilyEntity> familys;//家庭成员
    private EmployeeEntity employee;

    @Column(length = 20)
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Column(length = 30)
    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }

    @Enumerated(EnumType.ORDINAL)
    public Marriage getMarriage() {
        return marriage;
    }

    public void setMarriage(Marriage marriage) {
        this.marriage = marriage;
    }

    @Column(length = 20)
    public String getPhyle() {
        return phyle;
    }

    public void setPhyle(String phyle) {
        this.phyle = phyle;
    }

    @Column(length = 20)
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Column(length = 120)
    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactId")
    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "familyId")
    public List<FamilyEntity> getFamilys() {
        return familys;
    }

    public void setFamilys(List<FamilyEntity> familys) {
        this.familys = familys;
    }

    @Column(length = 20)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Temporal(TemporalType.DATE)
    public Date getIdCardValid() {
        return idCardValid;
    }

    public void setIdCardValid(Date idCardValid) {
        this.idCardValid = idCardValid;
    }

    @Column(length = 20)
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Temporal(TemporalType.DATE)
    public Date getPassportValid() {
        return passportValid;
    }

    public void setPassportValid(Date passportValid) {
        this.passportValid = passportValid;
    }
}
