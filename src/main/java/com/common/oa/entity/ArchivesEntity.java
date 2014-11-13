package com.common.oa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_archives")
public class ArchivesEntity extends BaseEntity{

    private String location;//档案所在地
    private String education;//最高学历
    private String major;//专业
    private Date startWork;//开始工作时间
    private String workCount;//工作年限
    private List<EducationEntity> educations = new ArrayList<EducationEntity>();//教育经历
    private List<WorkExperienceEntity> workExperiences = new ArrayList<WorkExperienceEntity>();//工作经历
    private List<TrainingExperienceEntity> trainingExperiences = new ArrayList<TrainingExperienceEntity>();//培训经历

    @Column(length = 120)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(length = 30)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Column(length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Temporal(TemporalType.DATE)
    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    @Column(length = 20)
    public String getWorkCount() {
        return workCount;
    }

    public void setWorkCount(String workCount) {
        this.workCount = workCount;
    }

    @OneToMany
    @JoinColumn(name = "educationId")
    public List<EducationEntity> getEducations() {
        return educations;
    }


    public void setEducations(List<EducationEntity> educations) {
        this.educations = educations;
    }

    @OneToMany
    @JoinColumn(name = "workExperienceId")
    public List<WorkExperienceEntity> getWorkExperiences() {
        return workExperiences;
    }


    public void setWorkExperiences(List<WorkExperienceEntity> workExperiences) {
        this.workExperiences = workExperiences;
    }

    @OneToMany
    @JoinColumn(name = "trainingExperienceId")
    public List<TrainingExperienceEntity> getTrainingExperiences() {
        return trainingExperiences;
    }

    public void setTrainingExperiences(List<TrainingExperienceEntity> trainingExperiences) {
        this.trainingExperiences = trainingExperiences;
    }
}
