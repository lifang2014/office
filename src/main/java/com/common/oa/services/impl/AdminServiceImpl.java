package com.common.oa.services.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.common.oa.dao.AdminDao;
import com.common.oa.dao.BaseDao;
import com.common.oa.entity.AdminEntity;
import com.common.oa.services.AdminService;

@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminEntity, Long> implements
		AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	@Autowired
	public void setBaseDao(BaseDao<AdminEntity, Long> baseDao) {
		super.setBaseDao(baseDao);
	}

	public AdminEntity findByUsername(String username) {
		if(StringUtils.isEmpty(username)) return null;
		return (AdminEntity) adminDao.findByUsername(username);
	}

	public void save(List<AdminEntity> lists) {
		for(AdminEntity admin : lists){
			adminDao.persist(admin);
		}
	}


}
