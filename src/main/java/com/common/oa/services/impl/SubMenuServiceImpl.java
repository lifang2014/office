package com.common.oa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.oa.dao.BaseDao;
import com.common.oa.entity.SubMenuEntity;
import com.common.oa.services.SubMenuService;

@Service
public class SubMenuServiceImpl extends BaseServiceImpl<SubMenuEntity, Long> implements SubMenuService {

	@Override
	@Autowired
	public void setBaseDao(BaseDao<SubMenuEntity, Long> baseDao) {
		super.setBaseDao(baseDao);
	}

	
	
}
