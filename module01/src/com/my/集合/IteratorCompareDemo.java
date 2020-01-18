package com.my.集合;

import java.util.*;

/**
 * @auther Summerday
 */
public class IteratorCompareDemo {

    public static void main(String[] args) {
        //ArrayList 有序
        List<String> list = new LinkedList<>();
        list.add("天");
        list.add("乔");
        list.add("巴");
        list.add("夏");
        //HashSet 无序
        Set<Integer> set = new HashSet<>();
        set.add(11);
        set.add(22);
        set.add(33);
        set.add(44);
        display(list.iterator());//天 乔 巴 夏
        System.out.println();
        display(set.iterator());//33 22 11 44
    }



    public static void display(Iterator<?> T){
        while(T.hasNext()){
            System.out.print(T.next()+" ");
        }
    }
}
