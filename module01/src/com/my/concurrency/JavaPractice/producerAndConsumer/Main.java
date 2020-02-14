package com.my.concurrency.JavaPractice.producerAndConsumer;

/**
 * @auther Summerday
 */
public class Main {
    public static void main(String[] args) {
        EvenStorage storage = new EvenStorage();

        Consumer consumer = new Consumer(storage);
        Producer producer = new Producer(storage);

        Thread consumerThread = new Thread(consumer);

        Thread producerThread = new Thread(producer);

        consumerThread.start();
        producerThread.start();

    }
}
