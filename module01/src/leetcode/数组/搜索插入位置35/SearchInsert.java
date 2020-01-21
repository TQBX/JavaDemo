package leetcode.数组.搜索插入位置35;

/**
 * @auther Summerday
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        SearchInsert s = new SearchInsert();
        System.out.println(s.searchInsert(nums, 7));
    }

    /**
     * 遍历法 时间复杂度O(n)
     *
     * @param nums   传入数组
     * @param target 传入目标元素值
     * @return 如果找到目标元素，返回目标元素的索引值；如果没有，则返回应该插入的索引位置
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        //num.length-1+1 比数组的最后一位nums.length-1多一位
        return nums.length;
    }
/*
    public int binarySerchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) return len;
        int left = 0;
        int right = len - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) left=mid+1;
            else right = mid-1;

        }
        return left;

    }
    */
    //二分查找
    public int binarySerchInsert(int[] nums, int target){
        int len = nums.length;
        if(len==0) return -1;
        if(nums[len-1]<target) return len;
        int left = 0;
        int right = len-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
