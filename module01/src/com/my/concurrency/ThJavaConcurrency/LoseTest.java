package com.my.concurrency.ThJavaConcurrency;

/**
 * @auther Summerday
 */
public class LoseTest {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        Sign sign = new Sign();
        new Thread(new B(sign)).start();
        new Thread(new A(sign)).start();
    }
}
class A implements Runnable{
    Sign sign;
    A(Sign sign){
        this.sign = sign;
    }
    @Override
    public void run() {
        System.out.println("1");
        synchronized (sign){
            System.out.println("2");
            sign.flag = false;
            sign.notify();
        }
    }
}
class B implements Runnable{
    Sign sign;
    B(Sign sign){
        this.sign = sign;
    }
    @Override
    public void run() {
        while (sign.flag){
            //point 1
            System.out.println("3");
            synchronized (sign){
                try {
                    System.out.println("4");
                    sign.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Sign{
    public boolean flag = true;
}