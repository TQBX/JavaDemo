package com.my.IO流.IO文件流;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @auther Summerday
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws Exception {
        //真正向文件中写数据的流是FileWriter，本身具有缓冲区
        //BufferedWriter 提供了更大的缓冲区
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\b.txt"));
        writer.write("天乔");
        //换行： Windows中换行是 \r\n   linux中只有\n
        //提供newLine() 统一换行
        writer.newLine();
        writer.write("巴夏");
        writer.close();
    }
}
