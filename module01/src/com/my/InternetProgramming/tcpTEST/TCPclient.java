package com.my.InternetProgramming.tcpTEST;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @auther Summerday
 */
public class TCPclient {
    public static void main(String[] args) throws IOException {

        //创建客户端对象
        Socket s = new Socket();

        //发起连接，自动进行三次握手
        s.connect(new InetSocketAddress("localhost",8090));

        //发送数据
        OutputStream out = s.getOutputStream(); //获取socket自带的输出流
        out.write("hello server".getBytes());

        //通知服务器端数据已经全部写完
        s.shutdownOutput();

        //关流
        s.close();
    }
}
