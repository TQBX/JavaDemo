package com.my.reflect.demo;

import com.my.base.Person;

import java.lang.reflect.Constructor;

/**
 * @auther Summerday
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {
        //获取Person的Class对象

        Class personClass = Person.class;

        //获取构造器
        Constructor constructor = personClass.getConstructor(int.class, String.class, String.class);
        System.out.println(constructor);

        //利用构造器创建对象
        Object person = constructor.newInstance(18,"jack","1243");
        System.out.println(person);


        System.out.println("----------------------");

        //获取空参构造器
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);

        //利用构造器创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);


        System.out.println("--------------------------");

        //使用空参构造器，可以调用Class类的newInstance()方法
        Object o = personClass.newInstance();
        System.out.println(o);


        //构造器的暴力破解
        constructor.setAccessible(true);

    }


}
