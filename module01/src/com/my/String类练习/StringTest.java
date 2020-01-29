package com.my.String类练习;

/**
 * @auther Summerday
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        swap(a,b);
        System.out.println(a);//a
        System.out.println(b);//b
    }

    public static void swap(String a, String b){
        String temp = a;
        a = b;
        b = temp;
    }
}
