package leetcode.数组.删除数组重复项;

import java.util.Arrays;

/**
 * @auther Summerday
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates re = new RemoveDuplicates();
        int[] nums1 = {1, 1, 1, 2, 2, 3, 4, 5, 5};
        System.out.println(re.removeDuplicates(nums1));//5
        System.out.println(Arrays.toString(nums1));//[1, 2, 3, 4, 5, 3, 4, 5, 5]

        int[] nums2 = {1, 2, 3, 4, 2, 3, 4, 5, 3, 2, 3};
        System.out.println(re.removeDuplicates(nums2, 4));//9
        System.out.println(Arrays.toString(nums2));//[1, 2, 3, 2, 3, 5, 3, 2, 3, 2, 3]

        int[] nums3 = {4, 1, 2, 3, 5, 4, 2, 3, 4, 5, 6};
        System.out.println(re.removeDuplicates00(nums3, 4));//8
        System.out.println(Arrays.toString(nums3));//[6, 1, 2, 3, 5, 5, 2, 3, 4, 5, 6]
    }

    /**
     * 删除数组中重复的项，并返回数组的长度
     *
     * @param nums 传入已排序的数组
     * @return 返回无重复项数组的长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //定义慢指针
        int i = 0;
        //定义快指针
        for (int j = 1; j < nums.length; j++) {
            //相等情况直接跳过
            //不相等时，将nums[j]的值赋值给nums[i+1]，然后递增i
            if (nums[j] != nums[i]) {

                nums[++i] = nums[j];
            }
        }
        //返回无重复项的长度
        return i + 1;
    }

    /**
     * 删除所有重复的val值，并返回数组的长度
     *
     * @param nums 传入的数组
     * @param val  删除数组中的所有val
     * @return 返回无重复数组的长度
     */
    public int removeDuplicates(int[] nums, int val) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public int removeDuplicates00(int[] nums, int val) {
        int i = 0;
        //定义变量len操作数组长度，因为本身是final的
        int len = nums.length;
        while (i < len) {

            if (nums[i] == val) {
                //相等的情况，将第一个与最后一个交换，
                // 因为数组顺序可以更改，[4，1，2，3，5],val=4,
                //可以避免不必要的移位
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }
}
