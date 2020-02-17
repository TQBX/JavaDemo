package com.my.IOstream.ioObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @auther Summerday
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建反序列化流
        //真正读取文件的是FileInputStream
        //ObjectInputStream将读取的字节转化为对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\1.data"));
        Person p = (Person)in.readObject();
        in.close();
        System.out.println(p.getName());//Niu
        System.out.println(p.getAge());//18

    }
}
