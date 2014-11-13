package com.common.oa.dao;

import com.common.oa.entity.AdminEntity;

public interface AdminDao extends BaseDao<AdminEntity, Long> {

	public AdminEntity findByUsername(String username);
	
}
