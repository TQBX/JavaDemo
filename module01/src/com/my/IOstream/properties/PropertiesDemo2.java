package com.my.IOstream.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @auther Summerday
 */
public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();

        //反序列化

        FileInputStream in = new FileInputStream("person.properties");

        prop.load(in);
        in.close();
        System.out.println(prop.getProperty("姓名"));
        //遍历prop
        prop.list(System.out);
        System.out.println(prop);
    }
}
