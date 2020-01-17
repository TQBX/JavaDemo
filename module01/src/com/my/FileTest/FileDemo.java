package com.my.FileTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * @auther Summerday
 */
public class FileDemo {
    public void cut(File src,File dest){
        if(src.isDirectory()) return;

        //获取要剪切文件的名字
        String fname = src.getName();
        //创建同名文件
        File newFile = new File(dest,fname);
        //试图剪切
        boolean b = src.renameTo(newFile);

        if(b) return;
        System.out.println("指定目录下包含同名文件，请选择操作：");
        System.out.println("1.移动并替换");
        System.out.println("2.保持不变");
        System.out.println("3.移动并保留两个文件");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<0||n>3)
            throw new IllegalArgumentException();
        if(n==1){
            newFile.delete();
            src.renameTo(newFile);
            return;
        }
        //获取.最后一次出现的位置

        if(n==2) return;
        int index = fname.lastIndexOf('.');
        String realname = fname.substring(0, index);
        String suffix = fname.substring(index);
        //如果选择了3,对文件进行编号
        //筛选要存放目录下的同名文件以及带着编号的文件
        File[]fs = dest.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals(fname)||name.matches(realname+"-\\d+"+suffix);
            }
        });
        if(fs == null) return;
        else{
            src.renameTo(new File(dest,realname+"-"+fs.length+suffix));
        }

    }

    public static void main(String[] args) {
        new FileDemo().cut(new File("D:\\a.txt"),new File("E:\\a.txt"));
    }
}
