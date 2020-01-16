package com.my.Java值传递;

/**
 * @author Summerday
 * @date 2019/12/1 15:30
 */
public class MethodTest {
    public static void main(String[] args) {
        //一、通过类直接调用static修饰的fourth()方法
        MethodTest.first();
        //MethodTest.second();错误
        //main方法static修饰，可以通过类直接调用static修饰的方法
        //二、创建实例对象，访问没有static修饰的普通方法
        MethodTest method = new MethodTest();
        method.second();
        //接收secondVal方法的返回值
        int secondValue = method.secondVal();
        System.out.println(secondValue);//10

        method.third(2);
        //接收thirdVal方法的返回值
        int thirdValue = method.thirdVal(20);
        System.out.println(thirdValue);//20

        method.fourth('a', 'b');
        method.fifth("hello","what's","your","name");
        System.out.println();
        method.sixth(new String[]{"hello","what's","your","name"});
    }

    //static修饰的静态方法
    public static void first(){
        System.out.println("static: no param...");
    }
    //无参数(无参无返）
    public void second() {
        System.out.println("no param..");
    }
    //无参有返
    public int secondVal(){
        return 10;
    }
    //一个参数（有参无返）
    public void third(int param1) {
        System.out.println("one param.. value is " + param1);
    }
    //有参有返
    public int thirdVal(int param1){
        return param1;
    }
    //两个参数
    public void fourth(char param1, char param2) {
        System.out.println("two params.. param1 is "
                + param1 + ",param2 is  " + param2);
    }
    //多个参数1
    //JDK1.5之后 在最后一个参数类型后加上...
    // 表明可以接收多个参数值，多个参数值被当作数组传入。
    //传入参数形式可以是多个参数以‘，’相隔，也可以传入数组
    //只能处于参数列表之后，所以一个方法中最多只能有一个长度可变的形参
    public void fifth(String...params){
        System.out.println("*type...param*");
        for(String param:params){
            System.out.print(param+" ");
        }
    }
    //错误：public void fifth1(String...params,int a )
    //多个参数2
    //采用数组形参来定义
    //只能接收数组
    //可以出现在形参列表的任意位置
    public void sixth(String[] params){
        System.out.println("*type[] param*");
        for(String param:params){
            System.out.print(param+" ");
        }
    }
}

