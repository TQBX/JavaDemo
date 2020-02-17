package com.my.InternetProgramming.filesUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther Summerday
 */
public class UploadServer {
    private static String fileName;
    private static String myDatas;

    public static void getData() throws IOException {
        // 创建服务器端对象
        ServerSocket ss = new ServerSocket(8090);

        // 接受连接
        Socket s = ss.accept();

        // 接收数据
        InputStream in = s.getInputStream();
        byte[] bs = new byte[1024];
        int len;
        String data = null;
        while((len = in.read(bs))!=  -1){
            data = new String(bs,0,len);
        }
        String[] datas = data.split(" ");
        fileName = datas[0]+"&";
        myDatas = datas[1];
        //通知客户端数据已经读完了
        s.shutdownInput();

        //关流
        ss.close();
    }
    public static void main(String[] args) throws IOException {
        getData();
        buildFile();

    }

    public static void buildFile() throws IOException {
        FileOutputStream out = new FileOutputStream(fileName);

        out.write(myDatas.getBytes());

        out.close();
    }
}
