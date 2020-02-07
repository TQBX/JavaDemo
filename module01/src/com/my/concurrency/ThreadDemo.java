package com.my.concurrency;


import java.util.concurrent.*;

/**
 * @auther Summerday
 */
public class ThreadDemo extends Thread {
    public static void main(String[] args){
//        TDemo t1 = new TDemo();
//        //启动线程
//        //start会给线程做很多配置,调用start和调用run不一样的
//        //配置完成之后会自动调用run方法执行指定的任务
//        t1.run();

//        TDemo t2 = new TDemo("t2");
//       t2.start();
//        System.out.print("main");





//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.print(Thread.currentThread().getName()+i);
//                }
//            }
//        }).start();

//        CDemo c = new CDemo();
//        //执行器服务 执行器助手
//        ExecutorService es = Executors.newCachedThreadPool();
//        Future<String> f = es.submit(c);
//        System.out.println(f.get());
//        es.shutdown();

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int i = 0;
                while(i<5){
                    System.out.println(Thread.currentThread().getName());
                    i++;
                }
                return i;
            }
        });
        for(int i = 0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
            if(i == 4){
                new Thread(task,"有返回值的线程").start();
            }
        }
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//创建一个线程类
class TDemo extends Thread{
    //线程要执行的任务在run方法中
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.print(this.getName()+i);
        }
    }
}
////实现Runnable接口
//class RDemo implements Runnable{
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//        }
//    }
//}

//实现Callable<T>接口
class CDemo implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "SUCCESS";
    }
}