package com.my.concurrency.JavaPractice.printjob;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Summerday
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();
    void printJob(Object document){
        queueLock.lock();
        System.out.printf("%S: Going to print a document\n",Thread.currentThread().getName());
        try{
            long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+":" +
                    "PrintQueue: printing a job during "+(duration/1000)+" seconds");
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] thread = new Thread[10];
        for(int i = 0;i<10;i++){

            thread[i] = new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }

}
class Job implements Runnable{
    private PrintQueue queue;
    Job(PrintQueue printQueue){
        queue = printQueue;
    }
    @Override
    public void run(){

        queue.printJob(new Object());
    }
}