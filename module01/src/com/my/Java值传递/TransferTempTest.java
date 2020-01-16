package com.my.Java值传递;

/**
 * @author Summerday
 * @date 2019/12/1 20:08
 */
public class TransferTempTest {
    public static void main(String[] args) {
        TransferTempTest test = new TransferTempTest();
        int num1 = 10;
        int num2 = 20;
        System.out.println("进行交换前：");
        System.out.println("num1 = " + num1 + ",num2 = " + num2);
        test.swap(10, 20);
        System.out.println("交换之后：");
        System.out.println("num1 = " + num1 + ",num2 = " + num2);
        System.out.println("*****************************");
        DataTemp data = new DataTemp();
        data.a = 2;
        data.b = 4;
        System.out.println("进行交换前：");
        System.out.println("data.a = " + data.a + ",data.b = " + data.b);
        data.swapClass(data);
        System.out.println("进行交换后：");
        System.out.println("data.a = " + data.a + ",data.b = " + data.b);
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("交换过程中：");
        System.out.println("num1 = " + a + ",num2 = " + b);
    }
}

class DataTemp {
    int a;
    int b;

    public void swapClass(DataTemp data) {
        int temp = data.a;
        data.a = data.b;
        data.b = temp;
        System.out.println("交换过程中：");
        System.out.println("data.a = " + data.a + ",data.b = " + data.b);

    }
}