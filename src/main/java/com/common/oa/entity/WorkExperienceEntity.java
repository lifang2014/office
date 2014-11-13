package com.common.oa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 工作经历
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_work_experience")
public class WorkExperienceEntity extends BaseEntity{

    private Date startWork;//开始时间
    private Date endWork;//结束时间
    private String companyName;//单位名称
    private String position;//担任岗位

    @Temporal(TemporalType.DATE)
    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    @Temporal(TemporalType.DATE)
    public Date getEndWork() {
        return endWork;
    }

    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    @Column(length = 30)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(length = 30)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
