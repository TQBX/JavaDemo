package com.my.concurrency;

/**
 * @auther Summerday
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PDemo(),"A");
        Thread t2 = new Thread(new PDemo(),"B");
        //默认情况下，线程的优先级
        System.out.println(t1.getPriority());//5
        System.out.println(t2.getPriority());//5

        //设置线程优先级
        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}

class PDemo implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        for (int i = 0; i < 10; i++) {
            System.out.println(name + ":" + i);
        }
    }
}