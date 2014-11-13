package com.common.oa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.common.oa.listener.EntityListener;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(EntityListener.class)
public class BaseEntity implements Serializable{

	private Long id;
	private Date createDate;//创建时间
	private Date modifyDate;//更新时间
	private Long companyId;//公司实例ID

	@Id
	@TableGenerator(name="GEN_INDEX",table="t_generator",
			pkColumnName = "gen_key",valueColumnName = "gen_value",
			pkColumnValue = "id",allocationSize = 2,initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "GEN_INDEX")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@NotBlank
	@NotEmpty
	@Column(length = 20)
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
