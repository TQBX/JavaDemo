package com.my.IO流.IO标准流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @auther Summerday
 */
public class SystemDemo {
    public static void main(String[] args) throws Exception {
        //读取数据
        //系统流是字节流，读取一个字节
//        int i = System.in.read();
//        System.out.println(i);
//        System.err.println(i);

        //System.out和System.err本质上是同一个东西
        //唯一区别打印颜色不同
        //实际使用过程中，正常结果用System.out打印
        //异常/错误用System.err 打印


        getLine();

    }

    //从控制台获取一行数据
    public static void getLine() throws IOException {
        //获取一行数据 -- BufferedReader
        //从控制台获取数据 -- System.in
        //System是字节流，BufferedReader在构建的时候需要传入字符流
        //将字节流转换为字符流
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        String str = br.readLine();
        System.out.println(str);


    }
}
