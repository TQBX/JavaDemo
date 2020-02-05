package com.my.other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @auther Summerday
 */

//java中断言默认不会开启,添加VM options  -ea
public class AssertDemo {

    public static void main(String[] args) {
        System.out.println("输入一个大于10的数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        n += 5;
        //对n的结果进行判断
//        if(n<=15)
//            throw new AssertionError();
        //如果满足条件，继续往下执行
        //如果不满足条件，抛出一个AssertionError的错误
        assert n > 15 : "需要一个大于10的数";

        n *= 3;
        System.out.println(n);
    }
    @Test
    public void m(){
        System.out.println("AssertDemo.m");
    }

    FileWriter out = null;
    @Before
    //在测试方法之前进行，一般用于进行初始化操作
    public void init() throws IOException{
        out = new FileWriter("D:\\m.txt");
    }
    @Test
    public void writeJava() throws IOException{
        out.write("Java");

    }
    @After
    //在测试方法之后执行，一般用于进行资源的销毁和回收
    public void close() throws IOException{
        out.close();
    }
}
