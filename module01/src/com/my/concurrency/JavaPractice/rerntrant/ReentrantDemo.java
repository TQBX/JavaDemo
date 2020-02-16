package com.my.concurrency.JavaPractice.rerntrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Summerday
 */
public class ReentrantDemo {
    public static void main(String[] args) {
        final Count count = new Count();
        for (int i = 0; i < 2; i++) {

            new Thread("getThread-" + i) {
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread("setThread-" + i) {
                @Override
                public void run() {
                    count.set();
                }
            }.start();
        }

    }
}

class Count {
    private final ReentrantLock lock = new ReentrantLock();//全部变量，此时下面的两个方法希望获取同一把锁

    public void get() {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get begin");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is working ");
                TimeUnit.SECONDS.sleep(1);
            }

            System.out.println(Thread.currentThread().getName() + " get end");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set() {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " set begin");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is working ");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + " set end");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}