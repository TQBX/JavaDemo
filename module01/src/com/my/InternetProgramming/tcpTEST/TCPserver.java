package com.my.InternetProgramming.tcpTEST;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther Summerday
 */
public class TCPserver {
    public static void main(String[] args) throws IOException {

        // 创建服务器端对象
        ServerSocket ss = new ServerSocket(8090);

        // 接受连接
        Socket s = ss.accept();

        // 接收数据
        InputStream in = s.getInputStream();
        byte[] bs = new byte[1024];
        int len;
        while((len = in.read(bs))!=  -1){
            System.out.println(new String(bs,0,len));
        }

        //通知客户端数据已经读完了
        s.shutdownInput();

        //关流
        ss.close();

    }
}
