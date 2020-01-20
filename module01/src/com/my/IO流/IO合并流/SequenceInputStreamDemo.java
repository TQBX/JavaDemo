package com.my.IO流.IO合并流;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @auther Summerday
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in1 = new FileInputStream("D:\\1.txt");
        FileInputStream in2 = new FileInputStream("D:\\a.txt");
        FileInputStream in3 = new FileInputStream("D:\\b.txt");
        FileInputStream in4 = new FileInputStream("D:\\m.txt");

        FileOutputStream out = new FileOutputStream("D:\\union.txt");
        //准备一个Vector存储输入流
        Vector<InputStream> v = new Vector<>();
        v.add(in1);
        v.add(in2);
        v.add(in3);
        v.add(in4);

        //利用Vector产生Enumeration对象
        Enumeration<InputStream> e = v.elements();
        //利用迭代器构建合并流
        SequenceInputStream s = new SequenceInputStream(e);

        //读取
        byte[] bs = new byte[10];
        int len;
        while((len = s.read(bs))!=-1){
            out.write(bs,0,len);
        }
        out.close();
        s.close();
    }
}
