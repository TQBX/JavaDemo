package com.my.网络编程;

import java.net.InetSocketAddress;

/**
 * @auther Summerday
 */
public class InetSocketAddressDemo {
    public static void main(String[] args) {
        //InetSocketAddress addr = new InetSocketAddress(port);//
        //绑定IP地址和端口号
        //127.0.0.1  localhost 默认指向当前计算机
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1",80);

        System.out.println(addr.getAddress());
        System.out.println(addr.getHostName());
        System.out.println(addr.getPort());
    }
}
