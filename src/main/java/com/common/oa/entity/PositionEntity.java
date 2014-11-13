package com.common.oa.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * 岗位实体类
 */
@Entity
@Table(name = "t_position")
public class PositionEntity extends BaseEntity{

    private String name;//岗位名称
    private Set<JobEntity> jobs = new TreeSet<JobEntity>();//拥有职务
    private OrganizationEntity organization;
    private Set<LeaderEntity> leaders = new TreeSet<LeaderEntity>();

    @Column(length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<JobEntity> getJobs() {
        return jobs;
    }

    public void setJobs(Set<JobEntity> jobs) {
        this.jobs = jobs;
    }

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<LeaderEntity> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<LeaderEntity> leaders) {
        this.leaders = leaders;
    }

    @ManyToOne
    @JoinColumn(name = "organizationId")
    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }
}
