package com.my.IOstream.ioSystem;

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
        //int i = System.in.read();
        //System.out.println(i);
        //System.err.println(i);

        //System.out和System.err本质上是同一个东西

        //唯一区别打印颜色不同

        //实际使用过程中，正常结果用System.out打印

        //异常/错误用System.err 打印

        //Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        getLine();

    }

    /**
     * 从控制台获取一行数据
     * @throws IOException  readLine 可能会抛出异常
     */
    public static void getLine() throws IOException {
        //获取一行字符数据 -- BufferedReader
        //从控制台获取数据 -- System.in
        //System是字节流，BufferedReader在构建的时候需要传入字符流
        //将字节流转换为字符流
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        //接收标准输入并转换为大写
        String str = br.readLine().toUpperCase();
        //发送到标准输出
        System.out.println(str);
    }
}
