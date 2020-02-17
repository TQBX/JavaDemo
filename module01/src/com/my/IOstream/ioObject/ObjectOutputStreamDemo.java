package com.my.IOstream.ioObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @auther Summerday
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setAge(18);
        p.setName("Niu");
        //创建序列化流
        //真正将数据写出的流是FileOutputStream
        //ObjectOutputStream将对象转化为字节
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\1.data"));

        out.writeObject(p);
        out.close();
    }
}
//必须实现Serializable接口
class Person implements Serializable {
    //序列化ID serialVersionUID
    private static final long serialVersionUID = 6402392549803169300L;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
