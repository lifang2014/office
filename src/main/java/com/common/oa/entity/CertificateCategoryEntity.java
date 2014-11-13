package com.common.oa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 证书类别实体类
 * Created by Administrator on 2014/11/9.
 */
@Entity
@Table(name = "t_certificate_category")
public class CertificateCategoryEntity extends BaseEntity{

    private String name;

}
