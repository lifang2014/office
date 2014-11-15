package com.common.oa.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 提醒规则表
 * Created by Jerry on 2014/11/14.
 */
@Entity
@Table(name = "t_notification_rule")
public class NotificationRuleEntity extends BaseEntity{

    private String name;//规则名称
    private int status;// 0有效, 1无效, 2过期, -1删除
    private int scope;//提醒范围 0指点人员, 1公司负责人
    private List<NotificationRecipientEntity> notificationRecipientEntities = new LinkedList<NotificationRecipientEntity>();//提醒接收人

    @Column(length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @OneToMany(mappedBy = "notificationRuleEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<NotificationRecipientEntity> getNotificationRecipientEntities() {
        return notificationRecipientEntities;
    }

    public void setNotificationRecipientEntities(List<NotificationRecipientEntity> notificationRecipientEntities) {
        this.notificationRecipientEntities = notificationRecipientEntities;
    }
}
