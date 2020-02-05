package com.my.concurrency.ThJavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther Summerday
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        //相当于线程数量为1的FixedThreadPool 多个任务使用相同的线程，排队执行
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
