package com.my.IO流.IO转换流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @auther Summerday
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //以字节形式读取FileInputStream,经过转换InputStreamReader -->字符
        //如果没有指定编码。使用的是默认的工程的编码
        FileInputStream in = new FileInputStream("D:\\b.txt");
        InputStreamReader ir = new InputStreamReader(in);
        char[] cs = new char[5];
        int len;
        while((len=ir.read(cs))!=-1){
            System.out.println(new String(cs,0,len));
        }
        ir.close();
    }
}
