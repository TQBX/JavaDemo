package com.my.concurrency.ThJavaConcurrency;

/**
 * @auther Summerday
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;//default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){

    }
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"List off!")+"),";
    }
    @Override
    public void run() {
        while(countDown-- >0){
            System.out.print(status());
            //对线程调度器的建议：将cpu从一个线程转移给另一个线程
            Thread.yield();
        }
    }
}
class MainThread{
    public static void main(String[] args) {
        //传入Runnable对象
        Thread t = new Thread(new LiftOff());
        //1.进行初始化操作，2.调用run方法
        t.start();
        //main()线程中的操作，可以看到是先输出出来了
        System.out.println("waiting for liftoff!");
    }
    public static void justInvokeRun(){
        //只是调用了run方法，并没有启动线程
        LiftOff launch = new LiftOff();
        launch.run();
    }

}
