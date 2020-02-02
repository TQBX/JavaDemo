package com.my.IO流.ThJavaInput;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @auther Summerday
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i + 1.414);
        }
        rf.writeUTF("the end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        //double 为8个字节 ，所以查找第五个数 5*8
        rf.seek(5 * 8);
        rf.writeDouble(47.001);
        rf.close();
        display();
    }
}
