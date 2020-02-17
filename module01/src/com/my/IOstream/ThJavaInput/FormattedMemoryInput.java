package com.my.IOstream.ThJavaInput;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @auther Summerday
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    //传入字节数组： new String().getBytes()
                    new ByteArrayInputStream(BufferedInputFile.read("FormattedMemoryInput.java").getBytes()));
            //while(true)  ...
            while (in.available() != 0) System.out.print((char) in.readByte());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
