package com.my.FileTest.directoryInfo;

import java.io.File;

/**
 * @auther Summerday
 */
public class MakeDirectory {
    private static void usage(){
        System.err.println("false!");
        System.exit(1);
    }
    private static void fileData(File f){
        System.out.println("" +
                "Absolute path: "+ f.getAbsolutePath()+
                " \n Can read: "+ f.canRead()+
                " \n Can write: "+ f.canWrite()+
                " \n getName: "+ f.getName()+
                " \n getParent: "+ f.getParent()+
                " \n get Path: "+ f.getPath()+
                " \n length: "+ f.length()+
                " \n lastModified: "+ f.lastModified());
        if(f.isFile()) System.out.println("it is a file!");
        else if(f.isDirectory()) System.out.println("it is a directory!");
    }

    public static void main(String[] args){
        fileData(new File(".\\module01\\src\\leetcode"));
    }
}
