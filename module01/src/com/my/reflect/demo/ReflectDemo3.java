package com.my.reflect.demo;

import com.my.base.Person;

import java.lang.reflect.Method;

/**
 * @auther Summerday
 */
public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {
        //获取Person的Class对象

        Class personClass = Person.class;

        //获取指定名称的方法
        Method doS = personClass.getMethod("doS");

        //执行方法
        Person p = new Person();
        doS.invoke(p);


        Method doS1 = personClass.getMethod("doS", String.class);

        doS1.invoke(p,"吃饭");

        System.out.println("-------------------");

        //获取所有public修饰的方法，包括Object类中的
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            //方法的暴力破解
            method.setAccessible(true);
            String name = method.getName();
            System.out.println(name+",\n"+method);
        }

        //在反射中，没啥是私有的，都可以暴力破解

        //获取全类名
        String className = personClass.getName();
        System.out.println(className);
    }


}