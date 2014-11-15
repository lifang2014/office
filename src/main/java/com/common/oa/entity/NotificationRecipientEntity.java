package com.common.oa.entity;

import javax.persistence.*;

/**
 * 通知提醒接收人实体类
 * Created by Jerry on 2014/11/14.
 */
@Entity
@Table(name = "t_notification_recipient")
public class NotificationRecipientEntity extends BaseEntity{

    private EmployeeEntity employeeEntity;//提醒人
    private NotificationRuleEntity notificationRuleEntity;

    @OneToOne
    @JoinColumn(name = "employeeId")
    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    @ManyToOne
    @JoinColumn(name = "notificationRuleId")
    public NotificationRuleEntity getNotificationRuleEntity() {
        return notificationRuleEntity;
    }

    public void setNotificationRuleEntity(NotificationRuleEntity notificationRuleEntity) {
        this.notificationRuleEntity = notificationRuleEntity;
    }
}
