package com.common.oa.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * 组织实体类
 * Created by Jerry on 2014/11/7.
 */
@Entity
@Table(name = "t_organization")
public class OrganizationEntity extends BaseEntity{

    private String name;//组织名称
    private Set<LeaderEntity> leaders = new TreeSet<LeaderEntity>();//组织对应领导人(多个)
    private Set<PositionEntity> positions = new TreeSet<PositionEntity>();//组织小拥有的岗位

    @Column(length = 50)
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<LeaderEntity> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<LeaderEntity> leaders) {
        this.leaders = leaders;
    }

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<PositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(Set<PositionEntity> positions) {
        this.positions = positions;
    }
}
