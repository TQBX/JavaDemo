package com.my.concurrency;

/**
 * @auther Summerday
 */
//利用多线程，模拟卖票场景
public class ThreadTests {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Seller(),"A");
        Thread t2 = new Thread(new Seller(),"B");
        Thread t3 = new Thread(new Seller(),"C");
        Thread t4 = new Thread(new Seller(),"D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
//线程类表示售票员
class Seller implements Runnable {
    private static int ticket = 300;

    @Override
    public void run() {
        while (ticket > 0) {
            ticket--;
            //currentThread() 获取当前在执行的线程
            String name = Thread.currentThread().getName();
            System.out.println(name + "卖了一张票" + ticket);
        }
    }
}
