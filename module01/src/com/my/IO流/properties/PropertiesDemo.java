package com.my.IO流.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @auther Summerday
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();

        //prop是映射 存储的是键值对  都是String类型
        //添加元素
        prop.setProperty("姓名","杰克");

        //用于序列化的方法
        //文件后缀名必须是 .properties

        //comments  注释
        FileOutputStream out = new FileOutputStream("person.properties");
        prop.store(out, "this is a person");

        out.close();

    }
}
