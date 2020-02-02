package com.my.IO流.ThJavaInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @auther Summerday
 */
//Buffered Input file
public class BufferedInputFile {
    //Throw exception to console
    public static String read(String filename) throws IOException {
        //Reading input by lines
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile("BufferedInputFile.java"));
    }


    public static String readFile(String filename) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(filename));
        LinkedList<String> results = new LinkedList<>();
        String s;
        while ((s = in.readLine()) != null) {
            results.add(s);
        }
        in.close();
        StringBuilder sb = new StringBuilder();
//        for(int i = results.size()-1;i>=0;i--){
//            sb.append(results.get(i)+"\n");
//        }
        Collections.reverse(results);
        Iterator<String> iterator = results.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next() + "\n");
        }
        return sb.toString();

    }


}
