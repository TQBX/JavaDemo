package com.my.集合;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @auther Summerday
 */
public class SetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("天");
        set.add("乔");
        set.add("巴");
        set.add("夏");
        set.add("天");
        set.add(null);
        set.add(null);

        System.out.println(set);//[乔, 巴, 天, 夏]
        //foreach 循环
        for(String s:set){
            System.out.println(s);
        }
        //forEach
        set.forEach(System.out::println);

        Set<Integer> treeSet = new TreeSet<>();
//        treeSet.add(null);
        treeSet.add(11);
        treeSet.add(95);
        treeSet.add(789);
        treeSet.add(4986);
        System.out.println(treeSet);//[11, 95, 789, 4986]

    }
}
