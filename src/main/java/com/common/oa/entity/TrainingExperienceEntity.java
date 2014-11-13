package com.common.oa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 培训经历实体类
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_training_experience")
public class TrainingExperienceEntity extends BaseEntity{

    private Date startTrain;//开始日期
    private Date endTrain;//结束日期
    private String content;//培训内容
    private String companyName;//培训机构
    private String certificate;//证书

    @Temporal(TemporalType.DATE)
    public Date getStartTrain() {
        return startTrain;
    }

    public void setStartTrain(Date startTrain) {
        this.startTrain = startTrain;
    }

    @Temporal(TemporalType.DATE)
    public Date getEndTrain() {
        return endTrain;
    }

    public void setEndTrain(Date endTrain) {
        this.endTrain = endTrain;
    }

    @Column(length = 120)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(length = 30)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(length = 120)
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
