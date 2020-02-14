package com.my.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @auther Summerday
 */
public class ClassDemo {


    public static void main(String[] args) throws ClassNotFoundException {


        Class<String> clz = String.class;
        System.out.println(clz);//class java.lang.String

        Object o = "abc";
        Class<String>  clazz = (Class<String>) o.getClass();
        System.out.println(clazz);//class java.lang.String


        Class<String> clazzz = (Class<String>)Class.forName("java.lang.String");
        System.out.println(clazzz);//class java.lang.String

        Class<int[]> clazzzz = int[].class;
        System.out.println(clazzzz);//class [I
    }


}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Tst{
    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, NoSuchFieldException {
        /*  无参构造
        //clz 代表Person类的字节码对象
        Class<Person> clz = Person.class;

        //利用字节码对象创建一个Person实例对象
        //底层 实际上是调用了这个类中的无参构造
        Person p = clz.newInstance();

        System.out.println(p);*/

        Class<Person> clz = Person.class;
        //获取类的含参构造器
        Constructor<Person> c =  clz.getConstructor(String.class);
        //利用构造器c创建实例
        Person p = c.newInstance("james");

        System.out.println(p.getName());
        //获取Person类的name属性
        Field f = clz.getDeclaredField("name");
        System.out.println(f);
        //属性为私有，暴力破解
        f.setAccessible(true);
        f.set(p,"jame");

        System.out.println(f.get(p));
    }
}