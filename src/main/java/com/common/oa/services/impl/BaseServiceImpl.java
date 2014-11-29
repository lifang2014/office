package com.common.oa.services.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.common.oa.entity.EmployeeEntity;
import com.common.oa.services.IdentityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;

import com.common.oa.dao.BaseDao;
import com.common.oa.services.BaseService;
import com.common.oa.utils.Page;

@Transactional
public class BaseServiceImpl<Entity, ID extends Serializable> implements BaseService<Entity, ID> {

	private BaseDao<Entity,ID> baseDao;

	public void setBaseDao(BaseDao<Entity,ID> baseDao){
		this.baseDao = baseDao;
	}
	
	
	@Transactional(readOnly=true)
	public Entity findByName(String name) {
		return this.baseDao.findByName(name);
	}
	
	@Transactional(readOnly=true)
	public List<Entity> findAll() {
		return this.baseDao.findAll(null);
	}

	@Transactional(readOnly=true)
	public Entity findById(ID id) {
		return this.baseDao.findById(id);
	}

	@Transactional
	public void update(Entity entity) {
		this.baseDao.update(entity);
	}
	
	@Transactional
	@CacheEvict(value = "menuCache",allEntries=true)
	public void delete(ID id) {
		this.baseDao.delete(id);
	}

	@Transactional(readOnly=true)
	public List<Entity> findAllByPage(Page page,String keyword) {
		return this.baseDao.findAllByPage(page,keyword);
	}
	
	@Transactional(readOnly=true)
	public List<Entity> findAllByPage(Page page) {
		return this.baseDao.findAllByPage(page,null);
	}

	@Transactional(readOnly=true)
	public Integer getCount(String keyword) {
		return this.baseDao.getCount(keyword);
	}
	
	@Transactional(readOnly=true)
	public Integer getCount() {
		return this.baseDao.getCount(null);
	}

	@Transactional
	public void delete(ID... ids) {
		for(ID id : ids){
			this.baseDao.delete(id);
		}
	}

	@Transactional
	public void delete(Entity entity){
		this.baseDao.delete(entity);
	}

	@Transactional
	public void delete(List<Entity> lists){
		for(Entity entity : lists){
			this.baseDao.delete(entity);
		}
	}

	@Transactional
	public void persist(Entity entity) {
		if(entity!=null) {
			this.baseDao.persist(entity);
		}
	}

	@Transactional
	public void merge(Entity entity){
		if(entity != null){
			this.baseDao.merge(entity);
		}
	}

	@Override
	@Transactional
	public void persistAll(Collection<Entity> entitys) {
		if(entitys.isEmpty())
			return;
		this.baseDao.persistAll(entitys);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Entity> findAllByCompanyId(Long companyId) {
		if(companyId == null) return null;
		return this.baseDao.findAllByCompanyId(companyId);
	}

}
