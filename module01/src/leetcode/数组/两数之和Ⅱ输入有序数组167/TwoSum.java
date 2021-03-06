package leetcode.数组.两数之和Ⅱ输入有序数组167;

import java.util.Arrays;

/**
 * @auther Summerday
 */

/*
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6}, 6)));
    }

    /**
     * 得到传入数组中两个元素和刚好是目标数字的位置，用数组返回
     * @param numbers   传入的目标数组
     * @param target    传入的目标数字
     * @return   返回两元素和为目标数字的对应位置
     */
    public static int[] twoSum(int[] numbers,int target){
        int i = 0;
        int j = numbers.length-1;
        if(numbers == null) return null;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum==target) return new int[]{i+1,j+1};
            else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}
