package com.my.concurrency;

/**
 * @auther Summerday
 */
public class LockDemo {
    static Printer p = new Printer();
    static Scan s = new Scan();

    public static void main(String[] args) {
        //多个线程之间的锁形成了嵌套，形成死锁DeadLock
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (p){
                    p.print();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s){
                        s.scan();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s){
                    s.scan();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (p){
                        p.print();
                    }
                }
            }
        }).start();
    }
}

class Printer{
    public void print(){
        System.out.println("Printer.print");
    }
}
class Scan{
    public void scan(){
        System.out.println("Scan.scan");
    }
}