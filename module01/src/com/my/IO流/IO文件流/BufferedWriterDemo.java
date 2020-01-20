package com.my.IO流.IO文件流;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @auther Summerday
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws Exception {
        //真正向文件中写数据的流是FileWriter
        //bw 提供了更大的缓冲区
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\b.txt"));

        writer.write("hua yu hao");

        //换行： Windows中换行是 \r\n   linux中只有\n
        //统一换行
        writer.newLine();
        writer.write("handsome");
        writer.close();

    }
}
