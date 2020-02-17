package com.my.IOstream.ioFile;

import java.io.FileOutputStream;

/**
 * @auther Summerday
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("D:\\b.txt");
        //写入数据
        //字节输出流没有缓冲区
        out.write("天乔巴夏".getBytes());
        //关流是为了释放文件
        out.close();
    }
}
