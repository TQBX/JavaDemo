package com.my.IO流.IO文件流;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileWriterDemo2 {
    public static void main(String[] args) {
        //将流对象放在try之外声明，并附为null，保证编译，可以调用close
        FileWriter writer = null;
        try {
            //将流对象放在里面初始化
            writer = new FileWriter("D:\\b.txt");
            writer.write("abc");

            //防止关流失败，没有自动冲刷，导致数据丢失
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //判断writer对象是否成功初始化
            if (writer != null) {
                //关流，无论成功与否
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //无论关流成功与否，都是有意义的：标为垃圾对象，强制回收

                    writer = null;
                }
            }
        }

    }
}
