package com.my.IOstream.ioFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileReaderDemo {
    public static void main(String[] args) throws Exception {
        //创建一个输入流对象指向D盘下的b.txt
        //文件字符输入流没有缓冲区
        FileReader reader = new FileReader("D:\\b.txt");
        //读取数据
        //每次只读取一个字符，所以返回值也就是表示读取的字符
        //定义一个变量记录每次读取的字符
//        int m;
//        //读取到末尾为-1
//        while((m = reader.read())!=-1){
//            System.out.println(m);
//        }
//        reader.close();
        FileWriter writer = new FileWriter("E:\\b.txt");
        copyFile(reader, writer);
    }


    public static void copyFile(FileReader reader, FileWriter writer) throws IOException {
        //利用字符数组作为缓冲区
        char[] cs = new char[5];
        //定义变量记录读取到的字符个数
        int m;
        while ((m = reader.read(cs)) != -1) {
            //将读取到的内容写入新的文件中
            writer.write(cs, 0, m);

        }
        reader.close();
        writer.close();
    }
}
