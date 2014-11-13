package com.common.oa.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 员工状态实体类
 * 员工状态通常有:试用期,在职，离职,休假,停职,退休,自离
 * Created by Administrator on 2014/11/9.
 */
@Entity
@Table(name = "t_employee_type")
public class EmployeeTypeEntity extends BaseEntity{

    @Column(length = 20)
    @NotBlank
    private String name;//状态名称
    private Integer sort;//排序字段

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
