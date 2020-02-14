package com.my.网络编程.filesUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @auther Summerday
 */
public class UploadClient {


    public static String getData(String fileName) throws IOException {
        String s = null;
        FileInputStream in = new FileInputStream(fileName);
        byte[] data = new byte[1024];
        int len;

        while ((len = in.read(data)) != -1) {
            s = new String(data, 0, len);
        }
        in.close();
        return fileName+" "+s;
    }
    public static void connect(String data) throws IOException {
        Socket s = new Socket();

        s.connect(new InetSocketAddress("127.0.0.1",8090));

        OutputStream out = s.getOutputStream();

        out.write(data.getBytes());

        s.shutdownOutput();

        s.close();
    }
    public static void main(String[] args) throws IOException {

        connect(getData("E:\\java_learning\\project01\\module01\\src\\com\\my\\网络编程\\filesUpload\\1.txt"));

    }
}
