package com.common.oa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 证书实体类
 * Created by Administrator on 2014/11/9.
 */
@Entity
@Table(name = "t_certificate")
public class CertificateEntity extends BaseEntity{

    private String name;//证书名称

}
