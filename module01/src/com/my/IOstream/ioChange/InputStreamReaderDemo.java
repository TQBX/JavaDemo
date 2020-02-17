package com.my.IOstream.ioChange;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @auther Summerday
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //以字节形式FileInputStream读取,经过转换InputStreamReader -->字符
        //如果没有指定编码。使用的是默认的工程的编码
        InputStreamReader ir =
                new InputStreamReader(
                        new FileInputStream("D:\\b.txt"));
        char[] cs = new char[5];
        int len;
        while((len=ir.read(cs))!=-1){
            System.out.println(new String(cs,0,len));
        }
        ir.close();
    }
}
