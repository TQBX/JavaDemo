package com.my.IOstream.ThJavaInput;

import java.io.*;

/**
 * @auther Summerday
 */
public class BasicsFileOutput {
    static String file = "BasicsFileOutput.out";

    public static void main(String[] args) throws IOException {
        //从BasicsFileOutput.java读取数据
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("BasicsFileOutput.java")));

        PrintWriter out =
                new PrintWriter(
                        //FileWriter 向文件中写入数据
                        new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        //保证缓冲区内容被清空
        out.close();
        //读取文件
        System.out.println(BufferedInputFile.read(file));
    }
}
