package com.common.oa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 教育经历实体类
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_education")
public class EducationEntity extends BaseEntity{

    private Date startDate;//开始时间
    private Date endDate;//结束时间
    private String schoolName;//学校名称
    private String major;//主修专业
    private String degree;//学位

    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(length = 30)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(length = 30)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Column(length = 20)
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
