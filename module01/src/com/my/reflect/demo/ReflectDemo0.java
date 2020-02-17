package com.my.reflect.demo;

import com.my.base.Person;

/**
 * @auther Summerday
 */
public class ReflectDemo0 {
    public static void main(String[] args) throws Exception {

        //Class.forName("全类名");
        Class cls1 = Class.forName("com.my.base.Person");
        System.out.println(cls1);

        //类名.class;
        Class cls2 = Person.class;
        System.out.println(cls2);

        //对象.getClass();
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        // == 比较三个对象,都是true

        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println(cls3 == cls2);


    }
}
