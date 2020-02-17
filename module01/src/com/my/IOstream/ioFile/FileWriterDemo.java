package com.my.IOstream.ioFile;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建一个新文件，如果原文件不存在，则操作创建的这个新文件
        //如果源文件存在，则利用新文件覆盖原文件
        FileWriter writer = new FileWriter("D:\\1.txt");
        try {
            //写数据
            /*写数据的时候，并不是直接写道文件中，而是先写到缓冲区
             *缓冲区满了之后，再将缓冲区中的数据写到文件中
             *在缓冲区没有满的时候，程序就已经结束，结果会导致数据死在缓冲区中。*/
            writer.write("abc");
            //冲刷缓冲区
            //将数据从缓冲区中冲到文件中
            writer.flush();
//        //关闭流
//        //为了释放文件以允许别的流来操作这个文件
//        //close之前，流自动进行一次flush操作以避免有数据死在缓冲区内
//        writer.close();
//        //清空引用将其标记为垃圾对象
//        writer = null;
//        System.out.println(writer);}
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //判断writer对象是否初始化成功
            try{
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                writer = null;
            }
        }
    }
}
