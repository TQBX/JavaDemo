package com.my.ExceptionTest;

import java.util.Scanner;

/**
 * @auther Summerday
 */
public class Quotient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Prompt the user to enter two integers:
        System.out.println("Enter two integers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        System.out.println(num1 / num2);

    }
}
