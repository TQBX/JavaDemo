package com.my.集合;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther Summerday
 */
public class QueueDemo {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

//        //添加元素
//        queue.add("a");
//        queue.offer("b");

        //获取并移除队头元素
        //如果队列为空，返回null
        System.out.println(queue.poll());

        //如果队列为空，抛出NoSuchElementException
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
