package com.my.concurrency.TestDemo;

import java.util.concurrent.TimeUnit;

/**
 * @auther Summerday
 */
public class Consumer implements Runnable {
    Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            synchronized (product) {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    while (!product.exist) {
                        product.wait();
                    }
                    System.out.println("消费一次");
                    product.exist = false;
                    product.notifyAll();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
