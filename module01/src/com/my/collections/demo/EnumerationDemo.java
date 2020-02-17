package com.my.collections.demo;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @auther Summerday
 */
public class EnumerationDemo {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("天");
        v.add("乔");
        v.add("巴");
        v.add("夏");
        //利用vector对象产生迭代器对象
        Enumeration<String> e = v.elements();
        //判断后边是否还有元素
        while(e.hasMoreElements()){
            //挪动指针指向下一个元素
            System.out.print(e.nextElement()+" ");
        }
    }
}
