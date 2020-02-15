package com.my.concurrency.JavaPractice.threadlocaldemo;

import java.util.concurrent.TimeUnit;

/**
 * @auther Summerday
 */
public class Profiler {
    // 定义一个ThreadLocal类型的变量，该变量是一个线程局部变量
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        //重写方法，为该局部变量赋初始值
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };
    //public void set(T value)，设置该局部变量值
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    //public T get() ，取出该局部变量的值
    public static final long cost(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    //测试
    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: "+ Profiler.cost()+" mills");

    }
}
