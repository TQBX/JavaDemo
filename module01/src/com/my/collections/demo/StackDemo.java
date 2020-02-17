package com.my.collections.demo;

import java.util.Stack;

/**
 * @auther Summerday
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        //入栈
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");


        //出栈
        System.out.println(s.pop());//e

        //h获取pop,如果栈为空则抛出空栈异常EmptyStackException
        System.out.println(s.peek());//d

        //判断栈是否为空
        System.out.println(s.empty());//false
        System.out.println(s.isEmpty());//false

        System.out.println(s);//[a,b,c,d]
        //从栈顶到占地来依次查找第一次出现的位置 以1为基数
        System.out.println(s.search("b"));//3

    }
}
