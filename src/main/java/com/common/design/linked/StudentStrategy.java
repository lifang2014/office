package com.common.design.linked;

/**
 * Created by Administrator on 2014/11/23.
 */
public class StudentStrategy implements Strategy{
    /**
     * 比较两个元素是否相等
     *
     * @param obj1
     * @param obj2
     * @return
     */
    @Override
    public boolean equal(Object obj1, Object obj2) {
        if(obj1 instanceof Student && obj2 instanceof Student){
            Student student_1 = (Student)obj1;
            Student student_2 = (Student)obj2;
            if(student_1.getId() == student_2.getId() && student_1.getName().equals(student_2.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * 比较两个元素的大小
     * 1、如果obj1 < obj2 返回 -1
     * 2、如果0jb1 = obj2 放回 0
     * 3、如果obj2 > obj2 返回 1
     *
     * @param obj1
     * @param obj2
     * @return
     */
    @Override
    public int compare(Object obj1, Object obj2) {
        return 0;
    }
}
