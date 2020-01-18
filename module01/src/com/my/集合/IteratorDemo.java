package com.my.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @auther Summerday
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("天");
        ls.add("乔");
        ls.add("巴");
        ls.add("夏");
        //增强for循环,本质上是一种迭代遍历
        //可以把增强for循环看作Iterator的简化形式
        for(String str : ls){
            System.out.print(str);
        }
        //下标遍历
        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i));
        }

        //迭代器遍历
        //获取迭代器
        Iterator<String> iterator = ls.iterator();
        iterator.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //判断是否有下一个元素
        while (iterator.hasNext()) {
            //挪动指针，指向下一个元素
            System.out.println(iterator.next());
//            String str = iterator.next();

//            if("天".equals(str)) iterator.remove();
//            System.out.print(str);


        }

//
        //forEach方法
        ls.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });

        ls.forEach(s -> System.out.print(s));
    }
}
