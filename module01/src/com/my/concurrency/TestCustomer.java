package com.my.concurrency;

/**
 * @auther Summerday
 */
//生产消费模型
    //生产者负责生产，消费者负责消费
    //生产者每生产一次，消费者就消费一次  生产与消费交替执行
public class TestCustomer {
    public static void main(String[] args) {
        Product p = new Product();
        new Thread(new Supplier(p)).start();
        new Thread(new Consumer(p)).start();
    }
}


//生产者
class Supplier implements Runnable{
    private Product p;
    public Supplier(Product p){
        this.p = p;
    }
    @Override
    public void run() {
        while(true){
            synchronized (p){
                //用if的情况，如果创建两个生产者，可能会导致一直在生产，改用while，唤醒之后仍需要判断flag
                if(p.flag == false)
                try {
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //计算本次生产的商品数量
                int count = (int)(Math.random()*1000);
                p.setCount(count);
                System.out.println("生产了"+count+"件商品");
                p.flag = false;
                p.notify();
            }
        }
    }
}
//消费者
class Consumer implements Runnable{
    private Product p;
    public Consumer(Product p){
        this.p = p;
    }
    @Override
    public void run() {
        while(true){
            synchronized (p){
                //生产的时候，消费陷入等待
                if(p.flag == true)
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                int count = p.getCount();
                p.setCount(0);
                System.out.println("消费了"+count+"件商品");
                p.flag = true;
                //唤醒等待的线程
                p.notify();
            }
        }
    }
}
//商品

class Product{
    private int count;
    //标记位--用于进行状态的标记
    //给标记位定义规则
    //如果为true，则进行生产，如果位false，则进行消费
    public boolean flag = true;
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}