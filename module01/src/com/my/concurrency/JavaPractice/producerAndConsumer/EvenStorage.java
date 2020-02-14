package com.my.concurrency.JavaPractice.producerAndConsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther Summerday
 */
public class EvenStorage {
    private int maxSize;
    private List<Date> storage;

    public EvenStorage() {
        maxSize = 5;
        storage = new LinkedList<>();
    }

    //存储事件
    public synchronized void set() {
        //如果storage已满，则不存储（等待）
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("set: " + storage.size());
        notifyAll();
    }

    //获取事件
    public synchronized void get() {
        //如果storage 为空，则无法取出，等待
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("get: %d %s \n", storage.size(), ((LinkedList<?>) storage).poll());
        notifyAll();
    }
}
