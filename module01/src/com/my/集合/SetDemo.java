package com.my.集合;

import java.util.HashSet;
import java.util.Set;

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

        System.out.println(set);//[乔, 巴, 天, 夏]

    }
}
