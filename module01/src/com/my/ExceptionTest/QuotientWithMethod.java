package com.my.ExceptionTest;

import java.util.Scanner;

/**
 * @auther Summerday
 */
public class QuotientWithMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Prompt the user to enter two integers:
        System.out.println("Enter two integers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        try {
            System.out.println(QuotientWithMethod.quotient(num1, num2));
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static int quotient(int num1, int num2) throws ArithmeticException{
        if (num2 == 0) {
            throw new ArithmeticException("Divisor can not be zero");
        }
        return num1 / num2;
    }
}
