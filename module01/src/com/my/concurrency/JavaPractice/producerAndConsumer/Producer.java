package com.my.concurrency.JavaPractice.producerAndConsumer;

/**
 * @auther Summerday
 */
public class Producer implements Runnable {
    private EvenStorage storage;

    public Producer(EvenStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.set();
        }
    }
}
