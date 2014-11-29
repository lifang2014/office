package com.common.oa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.common.oa.utils.Page;

public interface BaseDao<Entity,ID extends Serializable> {

	 /**
     * 保存
     * @param entity
     * @return
     * @throws Exception
     */
    public void persist(Entity entity);

    /**
     * 批量保存
     * @param entitys
     */
    public void persistAll(Collection<Entity> entitys);

    /**
     * 查询全部
     * @param keyword 查询关键字,为NULL查询全部
     * @return
     */
    public List<Entity> findAll(String keyword);

    /**
     * 通过名称查询
     * @param name
     * @return
     */
    public Entity findByName(String name);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(ID id);
    
    /**
     * 更新
     * @param entity
     * @return
     * @throws Exception
     */
    public void update(Entity entity);
    
    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    public void delete(ID id);

    /**
     * 删除一个实体
     * @param entity
     */
    public void delete(Entity entity);
    
    /**
     * 分页查询
     * @param page 分页信息类
     * @param keyword 查询关键字,为NULL查询全部
     * @return
     */
    public List<Entity> findAllByPage(Page page, String keyword);
    
    /**
     * 查询记录数量
     * @param keyword 查询关键字,为NULL查询全部
     * @return
     */
    public Integer getCount(String keyword);


    /**
     * 保存或更新
     * @param entity
     */
    public void merge(Entity entity);


    /**
     * 更加公司实例查询
     * @param companyId
     * @return
     */
    public List<Entity> findAllByCompanyId(Long companyId);

}
