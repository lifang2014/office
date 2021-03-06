package com.common.oa.services;

import java.util.List;

import com.common.oa.entity.AdminEntity;

public interface AdminService extends BaseService<AdminEntity, Long>{

	public AdminEntity findByUsername(String username);
	
	public void save(List<AdminEntity> lists);

	/**
	 * 获取当前登录用户
	 * @return
	 */
	public AdminEntity getCurrentUser();

}
