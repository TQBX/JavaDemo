package com.my.concurrency.ThJavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther Summerday
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        //一次性预先执行代价高昂的线程分配，限制线程的数量
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());

        }
        exec.shutdown();
    }
}
