package com.common.oa.services.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.common.design.observer.Subject;
import com.common.oa.params.Principal;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

	@Transactional(readOnly = true)
	public AdminEntity findByUsername(String username) {
		if(StringUtils.isEmpty(username)) return null;
		return (AdminEntity) adminDao.findByUsername(username);
	}

	@Transactional
	public void save(List<AdminEntity> lists) {
		for(AdminEntity admin : lists){
			adminDao.persist(admin);
		}
	}

	/**
	 * 获取当前登录用户
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public AdminEntity getCurrentUser() {
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		if(subject != null){
			Principal principal = (Principal)subject.getPrincipal();
			return adminDao.findById(principal.getId());
		}
		return null;
	}
}
