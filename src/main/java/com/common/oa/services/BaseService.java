package com.common.oa.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.common.oa.utils.Page;

public interface BaseService<Entity,ID extends Serializable> {

	   /**
     * 保存
     * @param entity
     * @return
     * @throws Exception
     */
    public void persist(Entity entity);

    /**
     * 评论保存
     * @param entitys
     */
    public void persistAll(Collection<Entity> entitys);
    
    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    public List<Entity> findAll();
    
    /**
     * 更加名称查询
     * @param name
     * @return
     */
    public Entity findByName(String name);
    
    /**
     * 根据主键ID查询
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
     * 根据主键删除
     * @param id
     * @return
     * @throws Exception
     */
    public void delete(ID id);
    
    /**
     * 根据主键删除多条数据
     * @param ids
     */
    public void delete(ID... ids);

    /**
     * 批量删除数据
     * @param lists
     */
    public void delete(List<Entity> lists);

    /**
     * 删除一个实体
     * @param entity
     */
    public void delete(Entity entity);
    
    /**
     * 分页查询
     * @param page
     * @return
     * @throws Exception
     */
    public List<Entity> findAllByPage(Page page);

    /**
     * 模糊查询+分页
     * @param page
     * @param keyword
     * @return
     */
    public List<Entity> findAllByPage(Page page, String keyword);
    
    /**
     * 查询总记录数
     * @return
     */
    public Integer getCount();

    /**
     * 模糊查询数据数量
     * @param keyword
     * @return
     */
    public Integer getCount(String keyword);

    /**
     * 保存或者更新
     * @param entity
     */
    public void merge(Entity entity);

    /**
     * 根据公司ID查询
     * @param companyId
     * @return
     */
    public List<Entity> findAllByCompanyId(Long companyId);
}
