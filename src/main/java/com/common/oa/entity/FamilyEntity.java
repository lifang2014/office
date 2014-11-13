package com.common.oa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 家庭成员实体类
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_family")
public class FamilyEntity extends BaseEntity{

    private String name;//性别
    private String relation;//与本人关系
    private String job;//职业
    private Date birthday;//出生年月
    private String tel;//联系电话

    @Column(length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 20)
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Column(length = 20)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
