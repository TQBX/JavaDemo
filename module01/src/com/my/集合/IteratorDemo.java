package com.my.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther Summerday
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        ls.add("d");
        ls.add("e");
        ls.add("f");

        //增强for循环,本质上是一种迭代遍历
        //可以把增强for循环看作Iterator的简化形式
        for(String str : ls){
            System.out.println(str);
        }
        //下标遍历
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
        //迭代器遍历
        //获取迭代器
        Iterator<String> iterator = ls.iterator();
        //判断是否有下一个元素
        while(iterator.hasNext()) {
            //挪动指针，指向下一个元素
            String str = iterator.next();
            System.out.println(str);

        }
    }
}
