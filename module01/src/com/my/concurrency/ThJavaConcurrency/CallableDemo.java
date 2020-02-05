package com.my.concurrency.ThJavaConcurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @auther Summerday
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //submit方法将会产生Future对象
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> result:results){
            try{
                System.out.println(result.get());
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult"+id;
    }
}
