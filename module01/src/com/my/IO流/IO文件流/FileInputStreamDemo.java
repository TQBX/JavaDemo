package com.my.IO流.IO文件流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("E:\\1myblog\\Javablog\\Collection\\pic\\Node.png");

        //读取字节
//        int i = in.read();
//        int i;
//        while((i=in.read())!=-1)
//            System.out.println(i);
        //字节数组
//        byte[] bs = new byte[10];
//        //定义变量记录每次实际读取的字节个数
//        int len;
//        while((len = in.read(bs))!=-1){
//            System.out.println(new String(bs,0,len));
//        }
//        in.close();
        FileOutputStream out = new FileOutputStream("E:\\1myblog\\Javablog\\Collection\\pic\\Node2.png");
        copyFile(in, out);

    }

    /**
     * 将源文件复制到新文件中
     * @param in 创建输入流指向源文件
     * @param out 创建输出流指向新文件
     * @throws IOException
     */
    public static void copyFile(FileInputStream in,FileOutputStream out) throws IOException {
        //创建一个字节数组作为缓冲区
        byte[] cs = new byte[1024];
        //定义变量记录当前读取的字节个数
        int len;
        while((len = in.read(cs))!=-1){
            //将读取到的内容写入新的文件中
            out.write(cs,0,len);

        }
        in.close();
        out.close();
    }






}
