package com.my.finalUse.demo;

/**
 * @auther Summerday
 */
public class FinalMethod {
    public final void test() {
        System.out.println("test()");
    }

    private final void test2() {
        System.out.println("test2()");
    }
    public final int age = 10;
    public int getAge(){
        return age;
    }
}

final class Subclass extends FinalMethod {
    //不能重写：public final void test()
    //可以重载
    public final void test(int a) {
        System.out.println("test()");
    }

    //!false:@Override
    public final void test2() {
        System.out.println("is not override test2()");
    }

    public static void main(String[] args) {
        Subclass sb = new Subclass();
        sb.test(2);
        sb.test();
        sb.test2();//并不是重写
        System.out.println(sb.age);
    }
}

//final修饰的类不能被继承 ：class Sub extends Subclass{}