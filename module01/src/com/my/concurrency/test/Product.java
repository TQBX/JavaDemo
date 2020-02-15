package com.my.concurrency.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Summerday
 */
public class Product {
    //共享产品编号
    private int count = 0;
    //标识位，标识是否还有产品
    private boolean flag = false;

    //创建Lock锁对象
    private Lock lock = new ReentrantLock();
    //创建两个Condition对象，作为两种条件检测
    private Condition condProducer = lock.newCondition();
    private Condition condConsumer = lock.newCondition();

    //生产方法
    public void produce() {
        lock.lock(); //上锁
        try {
            //驱使线程等待的条件
            while (flag) {
                condProducer.await(); //如果flag为true，则不用生产
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "生产产品一件,产品编号" + count);
            //生产完成，将标识为改为false
            flag = true;
            //唤醒conConsumer条件下的所有线程（当然，这里只有一个）
            condConsumer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//在finally中，保证解锁
        }
    }
    //消费方法
    public void consume() {
        lock.lock();
        try {
            //驱使线程等待的条件
            while (!flag) {
                condConsumer.await(); //如果flag为false，则不用消费
            }

            //消费的逻辑
            System.out.println(Thread.currentThread().getName() + "消费产品一件,产品编号" + count);
            flag = false;
            condProducer.signalAll();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
//生产者线程
class Producer implements Runnable {
    private Product product;

    Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        //每个生产者线程生产会生产五件产品
        for (int i = 0; i < 5; i++) {
            product.produce();
        }
    }
}
//消费者线程
class Consumer implements Runnable {
    private Product product;

    Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        //每个消费者线程会消费五件产品
        for (int i = 0; i < 5; i++) {
            product.consume();
        }
    }
}

class Main {
    public static void main(String[] args) {
        //创建产品对象
        Product product = new Product();

        //创建5个生产者线程并启动
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(product),"producer"+i).start();
        }
        //创建5个消费者线程并启动
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(product),"consumer"+i).start();
        }
    }
}