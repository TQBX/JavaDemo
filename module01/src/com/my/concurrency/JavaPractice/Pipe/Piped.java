package com.my.concurrency.JavaPractice.Pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @auther Summerday
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        //创建管道输入输出流
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        //将输入输出流连结起来，否则在使用的时候会抛出异常
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();

        //标准输入流转化到管道输出流
        int receive;
        try{
            while((receive = System.in.read())!=-1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

    //定义线程类，接收管道输入流，写入标准输出流
    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receive;
            try{
                while((receive = in.read())!=-1){
                    System.out.print((char)receive);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
