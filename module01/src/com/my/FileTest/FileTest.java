package com.my.FileTest;

import java.io.File;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //表示创建file对象,只是将传入的字符串标记成一个文件对象
        File file = new File("E:\\java_learning\\project01\\module01\\src\\leetcode");
        //当文件夹中不存在该文件时，才会创建一个新文件
        //仅用于创建文件
//        boolean b = file.createNewFile();
//        System.out.println(b);

        //创建目录
//        boolean b = file.mkdir();//创建单极目录
//        boolean b = file.mkdirs();

//        System.out.println(b);

        //删除文件/目录
        //不可逆，彻底删除,只能删除没有子目录或子文件的
//        file.delete();//删除文件


        //获取当前目录下的子文件和子目录 listFile()

//        File[] fs = file.listFiles();
//        for(File f:fs){
//            System.out.println(f);
//        }
        //判断是否是一个目录
//        System.out.println(file.isDirectory());
//        //判断是否是一个文件
//        System.out.println(file.isFile());
//        deleteDirectory(file);
//        System.out.println(sumJavaFile(file));
//        System.out.println(sumJavaFile(new File("E:\\java_learning\\project01\\module01\\src\\com")));

        System.out.println(File.separator);
        System.out.println(file.hashCode());
        System.out.println(file.getPath());
        System.out.println(file.compareTo(new File("D:"+File.separator+"a")));
//        System.out.println(file.toString());
    }

    /**
     * 静态方法，删除完整的目录
     * @param file 传入File对象
     */
    public static void deleteDirectory(File file){
        //判断file对象是文件还是目录
        if(file.isDirectory()){
            //如果是目录，获取子文件和子目录列表
            File[] fs = file.listFiles();
            //遍历数组
            for(File f :fs){
                //递归删除
              deleteDirectory(f);
            }
        }
        //最后的无论是啥，都需要删除
        file.delete();
    }


    static int sum = 0;

    /**
     * 静态方法，记录传入目录下java文件的个数
     * @param file 传入File对象
     * @return 传入目录下java文件的个数
     */
    public static int sumJavaFile(File file){
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f:fs){
                sumJavaFile(f);
            }
        }else if(file.getName().endsWith(".java")){
            sum++;
        }
        return sum;
    }
}
