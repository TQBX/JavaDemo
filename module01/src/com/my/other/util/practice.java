package com.my.other.util;

import java.util.Scanner;

/**
 * 非递归的方式求阶乘和
 * @auther Summerday
 */

public class practice {

    public static void main(String[] args) {
        //获取索引
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int sum = sum(index);
        int getSum = getSum(index);
        System.out.println(sum);
        System.out.println(getSum);


    }

    public static int sum(int index) {

        if (index < 0) return -1;
        //填表
        int[] arr = new int[index + 1];
        //0的阶乘 = 1
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * i;
        }
        //求和
        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += arr[i];
        }
        return sum;
    }


    public static int getSum(int n) {
        if (n == 0) return 1;
        int sum = 0;
        int isum = 0;
        for (int i = 1; i <= n; i++) {


            int temp = 1;
            for (int j = 1; j <= i; j++) {

                temp *= j;
                isum = temp;
            }
            sum += isum;
        }

        return sum + 1;
    }

}
