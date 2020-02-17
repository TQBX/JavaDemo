package com.my.IOstream.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @auther Summerday
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        Properties prop = new Properties();

        //prop是映射 存储的是键值对  都是String类型
        //添加元素
        prop.setProperty("姓名","天乔巴夏丶");

        //用于序列化的方法
        //文件后缀名必须是 .properties

        //comments  注释
        FileOutputStream out = new FileOutputStream(
                "E:\\java_learning\\project01\\module01\\src\\com\\my\\IOstream\\properties\\person.properties");
        prop.store(out, "this is me");

        out.close();

    }
}
