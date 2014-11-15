package com.common.oa.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 提醒消息实体类
 * Created by Jerry on 2014/11/14.
 */
@Entity
@Table(name = "t_notification")
public class NotificationEntity extends BaseEntity{

    private int status;//通知状态 0有效, 1已看，2忽略,-1删除
    private EmployeeEntity employee;//提醒人
    private NotificationRuleEntity notificationRule;//对应提醒规则

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @OneToOne
    @JoinColumn(name = "employeeId")
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public NotificationRuleEntity getNotificationRule() {
        return notificationRule;
    }

    public void setNotificationRule(NotificationRuleEntity notificationRule) {
        this.notificationRule = notificationRule;
    }
}
