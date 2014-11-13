package com.common.oa.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * 领导人(管理人员)实体类,对Employee的扩充
 * Created by Jerry on 2014/11/7.
 */
@Entity
@Table(name = "t_leader")
public class LeaderEntity extends BaseEntity{

    private int grade;//领导人级别,数值越小,能力越大
    private EmployeeEntity employee;
    private OrganizationEntity organization ;//对应组织
    private PositionEntity position;//对应岗位

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //必须存在关联关系,不存在抛出异常
    @OneToOne(optional = true)
    @JoinColumn(name = "employeeId")
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "organizationId")
    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "positionId")
    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }
}
