package com.my.concurrency.TestDemo;

import java.util.concurrent.TimeUnit;

/**
 * @auther Summerday
 */
public class Producer implements Runnable {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            synchronized (product) {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    while (product.exist) {
                        product.wait();
                    }
                    System.out.println("生产一次");
                    product.exist = true;
                    product.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
