package com.my.concurrency;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @auther Summerday
 */
//A、D、C、B总共卖100张，读取properties只需要改其中的配置文件即可，不需要改代码
public class SellTickets {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\java_learning\\project01\\module01\\src" +
                "\\com\\my\\concurrency\\ticketCount.properties";
        Properties prop = new Properties();
        prop.load(new FileInputStream(fileName));
        int ticketCount = Integer.parseInt(prop.getProperty("ticketCount"));
        Tickets t = new Tickets();
        t.setTicketCount(ticketCount);

        Thread t1 = new Thread(new Sellers(t),"A");
        Thread t2 = new Thread(new Sellers(t),"B");
        Thread t3 = new Thread(new Sellers(t),"C");
        Thread t4 = new Thread(new Sellers(t),"D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
//线程类表示售票员
class Sellers implements Runnable {
    private Tickets t;
    Sellers(Tickets t){
        this.t = t;
    }
    @Override
    public void run() {
        //循环在外，判断条件在里
        while (true) {
            //指定一个对象作为锁，需要所有的Sellers线程都认识这个对象，可以指定t为锁对象
//            synchronized (t) {
//            synchronized (Sellers.class){
            synchronized (Thread.class){
                if(t.getTicketCount()<=0)
                    break;
                try {
                    //让当前线程陷入休眠，时间单位毫秒
                    //不会改变线程的执行结果，只会把线程的抢占时间增长
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                t.setTicketCount(t.getTicketCount() - 1);
                //currentThread() 获取当前在执行的线程
                String name = Thread.currentThread().getName();
                System.out.println(name + "卖了一张票" + t.getTicketCount());
            }
        }
    }
}
//共用一份地址
class Tickets{
    private int ticketCount;
    public void setTicketCount(int ticketCount){
        this.ticketCount = ticketCount;
    }
    public int getTicketCount(){
        return ticketCount;
    }
}