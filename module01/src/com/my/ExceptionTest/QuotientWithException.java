package com.my.ExceptionTest;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @auther Summerday
 */
public class QuotientWithException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueFlag = true;
        do {
            try {
                //Prompt the user to enter two integers:
                System.out.println("Enter two integers: ");

                int num1 = input.nextInt();


                int num2 = input.nextInt();

                System.out.println(num1 + "/" + num2 + " = " + QuotientWithMethod.quotient(num1, num2));

                continueFlag = false;

            } catch (InputMismatchException e) {
                System.out.println("format wrong! try again!");
                input.nextLine();
//            input.nextInt();
            }
        } while (continueFlag);

    }

    public static int quotient(int num1, int num2) {
        if (num2 == 0)
            throw new ArithmeticException();

        return num1 / num2;
    }
}
