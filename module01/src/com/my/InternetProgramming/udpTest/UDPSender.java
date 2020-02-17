package com.my.InternetProgramming.udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @auther Summerday
 */


public class UDPSender {

    //UDP不建立连接，传输速度相对较快，不可靠
    public static void main(String[] args) throws IOException {

        //创建UDP发送端对象
        DatagramSocket ds = new DatagramSocket();

        // 准备数据包
        //buf = 实际数据
        //length = 数据的实际大小
        //address = 要发往的地址
        byte[] buf = "hello".getBytes();
        DatagramPacket dp = new DatagramPacket(
                buf, buf.length,new InetSocketAddress("127.0.0.1", 8090));

        //发送数据
        ds.send(dp);

        //关流
        ds.close();
    }
}
