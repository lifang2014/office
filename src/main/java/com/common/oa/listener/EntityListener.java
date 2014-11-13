package com.common.oa.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import com.common.oa.entity.BaseEntity;

public class EntityListener {

	/**
	 * Entity持久化时，自动创建时间
	 * @param entity
	 */
	@PrePersist
	public void prePersist(BaseEntity entity){
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
	}

	/**
	 * Entity更新时,自动更新时间
	 * @param entity
	 */
	@PreUpdate
	public void preUpdate(BaseEntity entity){
		entity.setModifyDate(new Date());
	}
}
