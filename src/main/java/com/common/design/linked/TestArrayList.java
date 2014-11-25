package com.common.design.linked;

/**
 * Created by Administrator on 2014/11/23.
 */
public class TestArrayList {

    public static void main(String[] args) throws OutOfBoundaryException{
//        Strategy strategy = new StudentStrategy();
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("B");
        System.out.println("size : " + list.size());
        System.out.println("isEmpty : " + list.isEmpty());
        System.out.println("contains B : " + list.contains("B"));
        System.out.println("indexOf D : " + list.indexOf("D"));
        System.out.println("list : " + list);
        list.insert(4, "E");
        list.insert(5,"F");
        list.insert(6,"G");
        list.insertBefore("A", "H");
        list.insertBefore("A","I");
        list.insertBefore("G","J");
        list.insertAfter("I","K");
        list.insertAfter("G","L");
        list.remove(2);
        list.remove("L");
        list.replace(2,"AA");
        list.replaceAll("B","BBB");
        System.out.println("list : " + list);
    }

}
