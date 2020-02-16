package com.my.concurrency.JavaPractice.tool;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Summerday
 */

//getHoldCount(): 返回当前线程获取锁的次数

//isHeldByCurrentThread(): 判断锁是否为当前线程所有




//自定义类继承ReentrantLock
public class MyLock extends ReentrantLock {

    private static final long serialVersionUID = -3258197982187227646L;

    //利用getOwner()得到当前线程
    private String getOwnerName() {
        if (this.getOwner() == null) {
            return "None";
        }
        return this.getOwner().getName();
    }
    //利用getQueuedThreads()返回在锁里的线程
    private Collection<Thread> getThreads() {
        return this.getQueuedThreads();
    }
    //创建内部类Task，实现Runnable接口
    public class Task implements Runnable {

        //申明一个私有Lock属性的lock
        private Lock lock;

        //实现构造器
        Task(Lock lock) {
            this.lock = lock;
        }
        //主任务
        void doSth() {
            //使用lock()获得锁
            lock.lock();
            System.out.printf("%s: Get the lock.\n", Thread.currentThread().getName());
            try {
                //休眠500毫秒
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.printf("%s: Free the lock.\n", Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        //定义线程执行体，调用doSth方法
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {

                doSth();
            }
        }
    }
    //测试
    public static void main(String[] args) throws InterruptedException {
        MyLock lock = new MyLock();
        Thread[] threads = new Thread[5];

        //创建并开始5个线程来执行5个task对象
        for (int i = 0; i < 5; i++) {
            Task task = lock.new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 15; i++) {

            //把锁的拥有者的名字写入操控台。

            System.out.printf("Main: Logging the Lock\n");

            System.out.printf("************************\n");

            System.out.printf("Lock: Owner : %s\n", lock.getOwnerName());

            //显示锁queued的线程的号码和名字。

            System.out.printf("Lock: Queued Threads: %s\n",

                    //判断是否有正在等待取锁的线程
                    lock.hasQueuedThreads()); // 译者注：加上 System

            if (lock.hasQueuedThreads()) {

                System.out.printf("Lock: Queue Length: %d\n",

                        //返回等待取锁的线程数量
                        lock.getQueueLength());

                System.out.printf("Lock: Queued Threads: ");

                //创建一个存储等待线程的集合
                Collection<Thread> lockedThreads = lock.getThreads();

                //foreach遍历，获取线程的名字
                for (Thread lockedThread : lockedThreads) {

                    System.out.printf("%s ", lockedThread.getName());

                }

                System.out.printf("\n");

            }


            //显示关于Lock对象的公平性和状态的信息。

            //判断该锁的fair模式是否被激活
            System.out.printf("Lock: Fairness: %s\n", lock.isFair());

            //判断该锁是否为某个线程所有
            System.out.printf("Lock: Locked: %s\n", lock.isLocked());

            System.out.printf("************************\n");


            //让线程休眠1秒，并合上类的循环。

            TimeUnit.SECONDS.sleep(1);

        }

    }
}
