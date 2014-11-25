package com.common.design.linked;

/**
 * List线性表接口
 * Created by Jerry on 2014/11/23.
 */
public interface List {

    /**
     * 获取线性表大小
     * @return
     */
    public int size();

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 判断线性表是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(Object e);

    /**
     * 返回元素在线性表中的序号，-1表示元素在线性表中不存在
     * @param e
     * @return
     */
    public int indexOf(Object e);

    /**
     * 向线性表中添加元素
     * @param e
     */
    public void add(Object e);

    /**
     * 将元素e插入到线性表i位置,i越界,将抛出异常
     * @param i
     * @param e
     * @throws OutOfBoundaryException
     */
    public void insert(int i, Object e) throws OutOfBoundaryException;

    /**
     * 将元素e插入到元素object之前
     * @param object
     * @param e
     */
    public void insertBefore(Object object, Object e);

    /**
     * 将元素e插入到元素object之后
     * @param object
     * @param e
     */
    public void insertAfter(Object object, Object e);

    /**
     * 删除线性表中序号为i的元素,i越界,抛出异常
     * @param i
     * @throws OutOfBoundaryException
     */
    public void remove(int i) throws OutOfBoundaryException;

    /**
     * 删除线性表中第一个与e相同的元素
     * @param e
     */
    public void remove(Object e);

    /**
     * 替换线性表中序号为i的元素为e
     * @param i
     * @param e
     * @throws OutOfBoundaryException
     */
    public void replace(int i, Object e)throws OutOfBoundaryException;

    /**
     * 获取线性表序号为i的元素
     * @param i
     * @return
     * @throws OutOfBoundaryException
     */
    public Object get(int i)throws OutOfBoundaryException;

    /**
     * 将线性表中全部的obj对象替换成e
     * @param obj
     * @param e
     */
    public void replaceAll(Object obj, Object e);
}
