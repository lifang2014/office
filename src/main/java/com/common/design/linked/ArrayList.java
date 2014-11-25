package com.common.design.linked;

/**
 * 数组方式现实线性表
 * Created by Jerry on 2014/11/23.
 */
public class ArrayList implements List{

    //默认数组长度
    private static final int LEN = 8;

    //比较策略
    private Strategy strategy;

    //数组大小
    private int size;

    /**
     * 定义一个数组
     */
    public Object[] objects;

    public ArrayList(){
        size = 0;
        objects = new Object[LEN];
    }

    public ArrayList(Strategy strategy){
        this.strategy = strategy;
        size = 0;
        objects = new Object[LEN];
    }

    /**
     * 获取线性表大小
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断线性表是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断线性表是否包含元素e
     *
     * @param e
     * @return
     */
    @Override
    public boolean contains(Object e) {
        for(int i = 0; i < size; i++){
            if(strategy != null) {
                if (strategy.equal(objects[i], e)) {
                    return true;
                }
            }else {
                if(e instanceof String){
                    if (objects[i].equals(e)) {
                        return true;
                    }
                }else{
                    if(objects[i] == e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 返回元素在线性表中的序号，-1表示元素在线性表中不存在
     *
     * @param e
     * @return
     */
    @Override
    public int indexOf(Object e) {
        for(int i = 0; i < size; i++){
            if(strategy != null) {
                if (strategy.equal(objects[i], e)) {
                    return i;
                }
            }else{
                if(e instanceof String){
                    if (objects[i].equals(e)) {
                        return i;
                    }
                }else{
                    if(objects[i] == e) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 将元素e插入到线性表i位置,i越界,将抛出异常
     *
     * @param i
     * @param e
     * @throws com.common.design.linked.OutOfBoundaryException
     */
    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {
        if(i < 0 || i > size){
            throw new OutOfBoundaryException("错误,指定的插入序号越界.");
        }
        if(size >= objects.length){
            expandSpace();
        }
        // j = size ，意味着已经把数组先后挪了一个位置，因为当前最大数组下标为 size - 1
        for(int j = size; j > i; j--){
            objects[j] = objects[j -1];
        }
        objects[i] = e;
        size ++;
    }

    /**
     * 扩充数组
     */
    private void expandSpace(){
        Object[] newObjects = new Object[objects.length * 2];
        for(int i = 0; i < objects.length; i++){
            newObjects[i] = objects[i];
        }
        objects = newObjects;
    }

    /**
     * 将元素e插入到元素object之前
     *
     * @param object
     * @param e
     */
    @Override
    public void insertBefore(Object object, Object e) {
        int index = indexOf(object);
        if(index != -1){
            try {
                insert(index, e);
            }catch (OutOfBoundaryException ex){
                //忽略异常，下标不会越界
            }
        }
    }

    /**
     * 将元素e插入到元素object之后
     *
     * @param object
     * @param e
     */
    @Override
    public void insertAfter(Object object, Object e) {
        int index = indexOf(object);
        if(index != -1){
            try {
                insert(index + 1, e);
            }catch (OutOfBoundaryException ex){
                //忽略异常，下标不会越界
            }
        }
    }

    /**
     * 删除线性表中序号为i的元素,i越界,抛出异常
     *
     * @param i
     * @throws com.common.design.linked.OutOfBoundaryException
     */
    @Override
    public void remove(int i) throws OutOfBoundaryException {
        if(i < 0 || i >= size){
            throw new OutOfBoundaryException("错误,指定的插入序号越界.");
        }
        for(int j = i; j < size -1 ; j++){
            objects[j] = objects[j + 1];
        }
        objects[--size] = null;
    }

    /**
     * 删除线性表中第一个与e相同的元素
     *
     * @param e
     */
    @Override
    public void remove(Object e) {
        int index = indexOf(e);
        if(index != -1){
            try{
                remove(index);
            }catch (OutOfBoundaryException ex){
                //ignore
            }
        }
    }

    /**
     * 替换线性表中序号为i的元素为e
     *
     * @param i
     * @param e
     * @throws com.common.design.linked.OutOfBoundaryException
     */
    @Override
    public void replace(int i, Object e) throws OutOfBoundaryException {
        if(i < 0 || i >= size){
            throw new OutOfBoundaryException("错误,指定的插入序号越界.");
        }
        objects[i] = e;
    }

    /**
     * 获取线性表序号为i的元素
     *
     * @param i
     * @return
     * @throws com.common.design.linked.OutOfBoundaryException
     */
    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if(i < 0 || i >= size){
            throw new OutOfBoundaryException("错误,指定的插入序号越界.");
        }
        return objects[i];
    }

    /**
     * 向线性表中添加元素
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        try {
            insert(size, e);
        }catch (OutOfBoundaryException ex){
            //ignore
        }
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p/>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        String str = "[";
        for(int i = 0; i < size; i++){
            str += objects[i];
            if( i != size -1)
                str += ",";
        }
        str += "]";
        return str;
    }

    /**
     * 将线性表中全部的obj对象替换成e
     *
     * @param obj
     * @param e
     */
    @Override
    public void replaceAll(Object obj, Object e) {
        int index = indexOf(obj);
        if(index != -1){
            if(strategy != null){
                for(int i = 0; i < size; i++){
                    if(strategy.equal(objects[i], obj)){
                        objects[i] = e;

                    }
                }
            }else{
                if(obj instanceof String){
                    for(int i = 0; i < size; i++){
                        if(objects[i].equals(obj)){
                            objects[i] = e;
                        }
                    }
                }else{
                    for(int i = 0; i < size; i++){
                        if(objects[i] == obj){
                            objects[i] = e;
                        }
                    }
                }
            }
        }
    }
}
