package com.my.IO流.RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @auther Summerday
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("D:\\a.txt","rw");
        // r 只读
        // rw 读和写
        //rwd、rws  数据不进入内存，直接写入底层存储设备。

        //在操作文件的时候将文件看作一个大型的字节数组
        //如果不指定，默认从下标0开始操作
        raf.write("hi".getBytes());


        //指定下标
        raf.seek(100);
//        raf.seek(5);

//        raf.write("he".getBytes());
        int i = raf.read();
        System.out.println((char)i);
        raf.close();

    }
}
