package com.my.concurrency;


import java.util.concurrent.*;

/**
 * @auther Summerday
 */
public class ThreadDemo extends Thread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        TDemo t1 = new TDemo("t1");
//        //启动线程
//        //start会给线程做很多配置,调用start和调用run不一样的
//        //配置完成之后会自动调用run方法执行指定的任务
//        t1.start();
//        TDemo t2 = new TDemo("t2");
//        t2.start();

//        RDemo r = new RDemo("r");
//        Thread t = new Thread(r);
//        t.start();

        CDemo c = new CDemo();
        //执行器服务 执行器助手
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> f = es.submit(c);
        System.out.println(f.get());
        es.shutdown();
    }
}

//创建一个线程类
class TDemo extends Thread{
    private String name;
    public TDemo(String name){
        this.name = name;
    }
    //线程要执行的任务在run方法中
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name+":"+i);
        }
    }
}
//实现Runnable接口
class RDemo implements Runnable{
    private String name;
    public RDemo(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+":"+i);
        }
    }
}

//实现Callable<T>接口
class CDemo implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "SUCCESS";
    }
}