package com.my.IOstream.ioPrint;

import java.io.PrintWriter;

/**
 * @auther Summerday
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        //第二个参数autoFlash设置为true，否则看不到结果
        PrintWriter p = new PrintWriter(System.out,true);
        p.println("hello,world!");
    }
}
