package com.my.IO流.IO打印流;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @auther Summerday
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {

        PrintStream p = new PrintStream("D:\\b.txt");
        p.write("abc".getBytes());

        p.write("def".getBytes());

        p.println("abc");
        p.println("def");
        //如果打印对象，默认调用对象身上的toString方法
        p.println(new Object());
        p.close();
    }
}
