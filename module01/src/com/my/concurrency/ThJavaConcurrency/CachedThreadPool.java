package com.my.concurrency.ThJavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther Summerday
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
