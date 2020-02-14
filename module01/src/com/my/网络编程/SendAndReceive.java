package com.my.网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @auther Summerday
 */
public class SendAndReceive {
    public static void main(String[] args) {
        new Thread(new Receiver()).start();
        new Thread(new Sender()).start();
    }
}
class Sender implements Runnable{
    private Scanner sc;
    private DatagramSocket ds;
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            ds = new DatagramSocket();

            // 准备数据包
            //buf = 实际数据
            //length = 数据的实际大小
            //address = 要发往的地址
            sc = new Scanner(System.in);
            InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 8090);
            while(true) {
                byte[] buf = sc.nextLine().getBytes();
                DatagramPacket dp = new DatagramPacket(
                        buf, buf.length,addr);

                //发送数据
                ds.send(dp);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*finally {
            ds.close();
        }*/


    }
}

class Receiver implements Runnable{
    private DatagramSocket ds;
    @Override
    public void run() {
        try {
            // 创建UDP接收端对象,绑定要监听的端口号
            ds = new DatagramSocket(8090);
            // 准备数据包
            // 底层实际上依靠传入的字节数组来存储数据
            //buf = 接收数据的数组
            //length = 数组中实际可用的大小
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            while(true) {
                // 接收数据
                // --阻塞--
                ds.receive(dp);
                // 将数据从数据包中解析出来
                // 获取底层的字节数组

                byte[] data = dp.getData();

                // 获取数据的实际大小
                int len = dp.getLength();

                // 获取发送者地址
                System.out.println(dp.getAddress());

                System.out.println(new String(data,0,len));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //持续发，不用关流
        /*finally {
            // 关流
            ds.close();
        }*/
    }
}
