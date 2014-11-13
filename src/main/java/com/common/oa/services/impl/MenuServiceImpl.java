package com.common.oa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.MenuEntity;
import com.common.oa.services.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuEntity, Long> implements MenuService {

	@Override
	@Autowired
	public void setBaseDao(BaseDao<MenuEntity, Long> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Cacheable("menuCache")
	@Override
	public List<MenuEntity> findAll() {
		return super.findAll();
	}

	@CacheEvict(value = "menuCache",allEntries=true)
	@Override
	public void persist(MenuEntity entity) {
		super.persist(entity);
	}
	
	@CacheEvict(value = "menuCache",allEntries=true)
	@Override
	public void delete(Long id) {
		super.delete(id);
	}

	
	
	
}
