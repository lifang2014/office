package com.common.oa.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 紧急联系人实体类
 * Created by Administrator on 2014/11/10.
 */
@Entity
@Table(name = "t_contact")
public class ContactEntity extends BaseEntity{

    private String name;//紧急联系人姓名
    private String relation;//与本人关系
    private String tel;//联系电话
    private String address;//联系人地址

    @Column(length = 30)
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 30)
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Column(length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(length = 120)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
