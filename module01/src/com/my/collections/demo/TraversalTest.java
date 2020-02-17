package com.my.collections.demo;

import java.util.*;

/**
 * @auther Summerday
 */
public class TraversalTest {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        /*ArrayList不得不加大数量观察它们的区别，其实差别不大*/
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i);
        }
        /*LinkedList 这个量级就可以体现比较明显的区别*/
        for(int i = 0;i<50000;i++){
            linkedList.add(i);
        }
        /*方法调用*/
//        forTest(arrayList);
//        iteratorTest(arrayList);
//        forTest(linkedList);
//        iteratorTest(linkedList);
        display(arrayList);
        display(linkedList);




    }
    /*for循环遍历的测试*/
    public static void forTest(List list){
        long start = System.currentTimeMillis();
        for (int i = 0,n=list.size(); i < n; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(list.getClass()+" for循环遍历测试 cost:"+time);
    }
    /*Iterator遍历的测试*/
    public static void iteratorTest(List list){
        long start = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println(list.getClass()+"迭代器遍历测试 cost:"+time);
    }

    public static void display(List<?> list){
        if(list instanceof RandomAccess){
            //如果支持快速随机访问
            forTest(list);
        }else {
            //不支持快速随机访问，就用迭代器
            iteratorTest(list);
        }
    }
}
