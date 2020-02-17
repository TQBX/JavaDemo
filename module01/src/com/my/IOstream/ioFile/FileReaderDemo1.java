package com.my.IOstream.ioFile;

import java.io.FileReader;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileReaderDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("D:\\b.txt");

        //定义数组作为缓冲区
        char[] cs = new char[5];
        //将数据读取到缓冲区中
        int len;
        while ((len = reader.read(cs)) != -1) {
            System.out.println(new String(cs, 0, len));
        }
        reader.close();
    }
}
