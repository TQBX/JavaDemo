package leetcode.数组.合并两个有序数组88;

import java.util.Arrays;

/**
 * @auther Summerday
 */

/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

 */
public class Merge {


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 4, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 合并并排序到第一个数组
     *
     * @param nums1 传入的第一个数组
     * @param m     第一个数组的长度
     * @param nums2 传入的第二个数组
     * @param n     第二个数组的长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;//指向nums1的有数字的最后一位
        int p2 = n - 1;//指向nums2的最后一位
        int p = m + n - 1;//p指向nums1的最后一位，已知nums1有足够大的空间
        //从有数字的最后一位向前，一一对比，两者较大的数存到nums1的最后一位
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        //由于是存到nums1上的，所以保证最后p1无元素可指的时候，把nums2上的元素按顺序拷贝到nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
