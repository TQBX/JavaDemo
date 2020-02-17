package com.my.FileTest.demo;

import java.io.File;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileFunction {
    public static void main(String[] args) throws IOException {



//        //假设事先已经创建该文件，并在文件内写入数据 11
//        File file = new File("D:\\1.txt");
//        file.length();         //2               获取文件长度（字节数），如果不存在或是目录，返回0
//        file.getParent();      //D:\             获取完整的父目录，若没有，则返回null
//        file.getPath();        //D:\1.txt        获取完整路径
//        file.getAbsolutePath();//D:\1.txt        获取绝对路径
//        file.lastModified();   //1580542165872   最后一次的修改时间（毫秒值）
//        file.getName();        //1.txt           获取对象的最后名字
//
//        File newFile = new File("D:");  //返回一个对象目录下所有文件组成的File列表
//        File[] fs = newFile.listFiles();
//        for(File f:fs) System.out.println(f.getName());


        File file = new File("relativeFile");
        file.getAbsolutePath(); //E:\java_learning\project01\relativeFile
        file.getPath();         //relativeFile
    }
}
