package com.common.oa.dao.impl;

import com.common.oa.dao.CompanyDao;
import com.common.oa.entity.CompanyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 * Created by Jerry on 2014/11/6.
 */
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<CompanyEntity, Long> implements CompanyDao{

    @Override
    public CompanyEntity findCompanyByNo(String companyNo){
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CompanyEntity> criteriaQuery = criteriaBuilder.createQuery(CompanyEntity.class);
            Root<CompanyEntity> root = criteriaQuery.from(CompanyEntity.class);
            EntityType<CompanyEntity> entityType = entityManager.getMetamodel().entity(CompanyEntity.class);

            if(entityType.getSingularAttribute("companyNo") == null){
                return null;
            }else{
                Predicate predicate = criteriaBuilder.equal(root.get(entityType.getSingularAttribute("companyNo", String.class)), companyNo);
                criteriaQuery.where(predicate);
                return entityManager.createQuery(criteriaQuery).getSingleResult();
            }
        }catch(NoResultException e){
            return null;
        }
    }

}
