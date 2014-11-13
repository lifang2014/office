package com.common.oa.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * 职务实体类
 */
@Entity
@Table(name="t_job")
public class JobEntity extends BaseEntity{

    private String name;//职务名称
    private PositionEntity position;//所属岗位

    @Column(length = 50)
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
