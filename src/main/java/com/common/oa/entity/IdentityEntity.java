package com.common.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 自动生成不重复编号
 * 编号由key(字符) + value(数值)组成
 * Created by Jerry on 2014/11/26.
 */
@Entity
@Table(name = "t_identity")
public class IdentityEntity extends BaseEntity{

    private String keyword;//编号组成字符
    private Long value = 1000L;//编号组成数值,默认值为1000
    private int step = 1;//数值型编号,每次编号值增加的大小,默认为 1
    private String clazz;//编号应用类名称(组织编号,岗位编号...),通过

    @Column(length = 10)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
