package com.my.IO流.IO标准流;

import java.io.*;

/**
 * @auther Summerday
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in =
                new BufferedInputStream(
                        new FileInputStream("Redirecting.java"));
        PrintStream out =
                new PrintStream(
                        new BufferedOutputStream(
                                new FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine())!=null)
            System.out.println(s);
        out.close();
        System.setOut(console);
    }
}
