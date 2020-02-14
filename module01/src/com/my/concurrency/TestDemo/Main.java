package com.my.concurrency.TestDemo;


/**
 * @auther Summerday
 */
public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Thread producer = new Thread(new Producer(product));
        Thread consumer = new Thread(new Consumer(product));

        producer.start();
        consumer.start();

    }
}
