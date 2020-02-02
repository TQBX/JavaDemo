package com.my.IO流.ThJavaInput;

import java.io.IOException;
import java.io.StringReader;

/**
 * @auther Summerday
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}
