package com.common.oa.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.common.oa.dao.BaseDao;
import com.common.oa.utils.Page;

public abstract class BaseDaoImpl<Entity,ID extends Serializable> implements BaseDao<Entity, ID> {

	private Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

	@PersistenceContext
	public EntityManager entityManager;
	
	public Class<Entity> entityClass;
	
	//模糊查询关键字
	private final static String M_KEYWORK_NAME = "name";
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class<Entity>) parameterizedType[0];
	}
	
	public void persist(Entity entity){
		entityManager.persist(entity);
	}
	
	public void merge(Entity entity){
		entityManager.merge(entity);
	}
	
	public Entity findByName(String name) {
		try{
			CriteriaBuilder queryBinder = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<Entity> criteriaQuery = queryBinder.createQuery(entityClass);
			
			Root<Entity> root = criteriaQuery.from(entityClass);
			
			EntityType<Entity> entityType = entityManager.getMetamodel().entity(entityClass);
			
			if(entityType.getSingularAttribute(M_KEYWORK_NAME)==null) return null;
			
			Predicate predicate = queryBinder.equal(root.get(entityType.getSingularAttribute(M_KEYWORK_NAME,String.class)), name);
			
			criteriaQuery.where(predicate);
			
			return entityManager.createQuery(criteriaQuery).getSingleResult();
		}catch(NoResultException e){
			return null;
		}

	}

	public List<Entity> findAll(String keyword) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<Entity> root = criteriaQuery.from(entityClass);
		if(StringUtils.isEmpty(keyword)){
			criteriaQuery.select(root);
		}else{
			EntityType<Entity> entityType = entityManager.getMetamodel().entity(entityClass);
			if(entityType.getSingularAttribute(M_KEYWORK_NAME)==null) return null;
			criteriaQuery.where(criteriaBuilder.like(root.get(entityType.getSingularAttribute(M_KEYWORK_NAME, String.class)),"%"+keyword+"%"));
		}
		return entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT).getResultList();
	}

	public Entity findById(ID id) {
		return entityManager.find(entityClass, id);
	}

	public void update(Entity entity) {
		Assert.notNull(entity);
		entityManager.merge(entity);
	}

	public void delete(ID id) {
		entityManager.remove(entityManager.find(entityClass, id));
	}

	public void delete(Entity entity){
		entityManager.remove(entity);
	}
	
	public List<Entity> findAllByPage(Page page,String keyword) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<Entity> root = criteriaQuery.from(entityClass);
		if(StringUtils.isEmpty(keyword)){
			criteriaQuery.select(root);
		}else{
			EntityType<Entity> entityModel = entityManager.getMetamodel().entity(entityClass);//类实例模型
			if(entityModel.getSingularAttribute(M_KEYWORK_NAME)==null) return null;
			criteriaQuery.where(criteriaBuilder.like(root.get(entityModel.getSingularAttribute(M_KEYWORK_NAME,String.class)), "%"+keyword+"%"));
		}
		return entityManager.createQuery(criteriaQuery).setFirstResult(page.getBeginIndex()).setMaxResults(page.getEveryPage()).getResultList();
	}

	public Integer getCount(String keyword) {
		return this.findAll(keyword).size();
	}

	@Override
	public void persistAll(Collection<Entity> entitys) {
		for(Entity entity : entitys){
			entityManager.persist(entity);
		}
	}

	@Override
	public List<Entity> findAllByCompanyId(Long companyId) {
		String keyValue = "companyId";
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<Entity> root = criteriaQuery.from(entityClass);
		EntityType<Entity> entityType = entityManager.getMetamodel().entity(entityClass);
		if(entityType.getSingularAttribute(keyValue) == null){
			return null;
		}else{
			Predicate predicate = criteriaBuilder.equal(root.get(entityType.getSingularAttribute(keyValue, Long.class)), companyId);
			criteriaQuery.where(predicate);
			return entityManager.createQuery(criteriaQuery).getResultList();
		}
	}

}
