package com.my.IO流.IO转换流;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @auther Summerday
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws Exception {
        //在构建转换流时需要传入一个OutputStream  字节流
        OutputStreamWriter ow =
                new OutputStreamWriter(
                        new FileOutputStream("D:\\b.txt"),"utf-8");
        //给定字符--> OutputStreamWriter转化为字节-->以字节流形式传入文件FileOutputStream
        //如果没有指定编码，默认使用当前工程的编码
        ow.write("天乔巴夏");
        ow.close();
    }
}
