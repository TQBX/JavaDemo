package com.my.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther Summerday
 */
public class TraversalTest {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {

            arrayList.add(i);
        }
        for(int i = 0;i<50000;i++){
            linkedList.add(i);
        }
        forTest(arrayList);
//        iteratorTest(arrayList);
        forTestNew(arrayList);
//        forTest(linkedList);

//        iteratorTest(linkedList);


    }
    public static void forTest(List list){
        long start = System.currentTimeMillis();
        for (int i = 0,n=list.size(); i < n; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(list.getClass()+" for test cost:"+time);
    }
    public static void forTestNew(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i <list.size(); i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(list.getClass()+" for testNew cost:"+time);
    }
    public static void iteratorTest(List list){
        long start = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println(list.getClass()+"iterator test cost:"+time);
    }
}
