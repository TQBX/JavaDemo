package com.my.IO流;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileWriterDemo3 {
    public static void main(String[] args) {
        //JDK1.7出现新的异常处理方式--- try-with-resources
        //要求被处理的对象对应的类必须实现AutoCloseable AutoFlushable
        //要求处理的对象的声明过程必须在try之外
        try(FileWriter writer = new FileWriter("M:\\c.txt")){
            writer.write("abc");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
