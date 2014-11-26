package com.common.oa.dao.impl;

import com.common.oa.dao.IdentityDao;
import com.common.oa.entity.IdentityEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;

/**
 * Created by Jerry on 2014/11/26.
 */
@Repository
public class IdentityDaoImpl extends BaseDaoImpl<IdentityEntity,Long> implements IdentityDao{

    @Override
    public IdentityEntity findIdentityEntity(String companyId, String clazz) {

        try {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<IdentityEntity> criteriaQuery = criteriaBuilder.createQuery(IdentityEntity.class);

            Root<IdentityEntity> root = criteriaQuery.from(IdentityEntity.class);

            Path<String> p_commpanyId = root.get("companyId");

            Path<String> p_clazz = root.get("clazz");

            Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(p_commpanyId, companyId), criteriaBuilder.equal(p_clazz, clazz));

            criteriaQuery.where(predicate);

            return entityManager.createQuery(criteriaQuery).getSingleResult();

        }catch (NoResultException e){

            return null;

        }
    }
}
