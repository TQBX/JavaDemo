package com.my.网络编程.udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @auther Summerday
 */
public class UDPReceiver {
    public static void main(String[] args) throws IOException {

        // 创建UDP接收端对象,绑定要监听的端口号
        DatagramSocket ds = new DatagramSocket(8090);

        // 准备数据包
        // 底层实际上依靠传入的字节数组来存储数据
        //buf = 接收数据的数组
        //length = 数组中实际可用的大小
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);

        // 接收数据
        // --阻塞--
        ds.receive(dp);

        // 关流
        ds.close();

        // 将数据从数据包中解析出来
        // 获取底层的字节数组
        byte[] data = dp.getData();

        // 获取数据的实际大小
        int len = dp.getLength();

        // 获取发送者地址
        System.out.println(dp.getAddress());

        System.out.println(new String(data,0,len));
    }
}
