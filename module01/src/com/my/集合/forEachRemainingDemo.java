package com.my.集合;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @auther Summerday
 */
public class forEachRemainingDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //创建一个Iterator对象
        Iterator<Integer> it = list.iterator();
        //返回第一个值
        System.out.print(it.next()+" ");
        System.out.print(it.next()+" ");
        it.remove();
        it.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        for(Integer integer:list){
            System.out.println(integer);
        }
    }
}
