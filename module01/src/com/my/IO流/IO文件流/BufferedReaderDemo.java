package com.my.IO流.IO文件流;

import java.io.*;

/**
 * @auther Summerday
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        /*FileReader reader = new FileReader("D:\\b.txt");
        BufferedReader br = new BufferedReader(reader);
        //读取一行
//        String str = br.readLine();

//        System.out.println(str);

        //定义一个变量来记录读取的每一行的数据（回车）
        String str;
        //读取到末尾返回null
        while((str = br.readLine())!=null){
            System.out.println(str);
        }
        //关外层流即可
        br.close();*/

        countJavaCode(new File("E:\\java_learning\\project01\\module01\\src\\leetcode\\pac20"));
        System.out.println(count);
    }


    static int count = 0;

    /**
     * 记录Java文件的代码行数(还增加了打印）
     * @param file 传入File对象
     * @throws IOException
     */
    public static void countJavaCode(File file) throws IOException {
        //判断目录还是文件
        if(file.isDirectory()){
            //获取目录下所有的子目录和子文件
            File[] fs = file.listFiles();
            for(File f:fs){
                countJavaCode(f);

            }
        }else if(file.getName().endsWith(".java")){
            //读取行数
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while((str = reader.readLine())!=null){
                System.out.println(str);
                count++;
            }
            reader.close();
        }
    }



}
