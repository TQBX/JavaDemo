package com.my.concurrency.JavaPractice.producerAndConsumer;

/**
 * @auther Summerday
 */
public class Consumer implements Runnable {
    private EvenStorage storage;

    public Consumer(EvenStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.get();
        }
    }
}
