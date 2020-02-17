package com.my.reflect.demo;

import com.my.base.Person;

import java.lang.reflect.Field;

/**
 * @auther Summerday
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws Exception {
        //获取Person的Class对象

        Class personClass = Person.class;
        //获取所有public 修饰的成员变量
        Field[] fs = personClass.getFields();

        for (Field f : fs) {
            System.out.println(f);
        }

        System.out.println("------------------");

        //获取public的成员变量，指定名字
        Field id = personClass.getField("ID");

        //获取成员变量的值
        Person p = new Person();
        Object value = id.get(p);
        System.out.println(value);

        //设置值
        id.set(p, "123");

        System.out.println(p);

        System.out.println("-----------------");

        //获取所有成员变量，不考虑修饰符
        Field[] fss = personClass.getDeclaredFields();
        for (Field field : fss) {
            System.out.println(field);
        }

        ////获取成员变量，不考虑修饰符，但在访问时需要暴力破解
        Field name = personClass.getDeclaredField("name");

        //暴力破解,忽略访问权限修饰符的安全检查
        name.setAccessible(true);

        Object v = name.get(p);
        System.out.println(v);

    }


}
