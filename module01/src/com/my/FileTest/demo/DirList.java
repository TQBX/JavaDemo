package com.my.FileTest.demo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @auther Summerday
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File("module01\\src\\com\\my\\FileTest");
        File[] list;
        list = path.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        for(File l:list) {
            if(l!=null) {
                System.out.println(l.getName());
            }
        }

    }
}
