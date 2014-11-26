package com.common.oa.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.stereotype.Repository;

import com.common.oa.dao.AdminDao;
import com.common.oa.entity.AdminEntity;

@Repository
public class AdminDaoImpl extends BaseDaoImpl<AdminEntity, Long> implements AdminDao {

	public AdminEntity findByUsername(String username) {
		try{
		
			CriteriaBuilder queryBinder = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<AdminEntity> criteriaQuery = queryBinder.createQuery(AdminEntity.class);
			
			Root<AdminEntity> root = criteriaQuery.from(AdminEntity.class);
			
			EntityType<AdminEntity> entityType = entityManager.getMetamodel().entity(AdminEntity.class);
			
			if(entityType.getSingularAttribute("username") == null) return null;
			
			Predicate predicate = queryBinder.equal(root.get(entityType.getSingularAttribute("username",String.class)), username);
			
			criteriaQuery.where(predicate);
			
			return entityManager.createQuery(criteriaQuery).getSingleResult();
		
		}catch(NoResultException e){
			return null;
		}
	}

}
