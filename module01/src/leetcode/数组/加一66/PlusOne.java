package leetcode.数组.加一66;

import java.util.Arrays;

/**
 * @auther Summerday
 */


/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 */
public class PlusOne {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }


    /**
     * 将一个用表示数字的数组传入，加上1之后，返回新数组
     * @param digits  传入的数组
     * @return  返回加一之后的新数组
     */
    public static int[] plusOne(int[] digits){
        int len = digits.length;
        for(int i = len-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            //末位不是9，直接返回该数组
            if(digits[i]!=0) return digits;

        }
        //最高位为9的情况，创建一个比原数组长1的新数组
        int[] newDigits = new int[len+1];
        //将新数组的首位置1，其余初始化为0
        newDigits[0] = 1;
        return newDigits;
    }
}
