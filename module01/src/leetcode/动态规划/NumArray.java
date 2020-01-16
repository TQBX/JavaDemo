package leetcode.动态规划;

/**
 * @auther Summerday
 */
public class NumArray {
    private int[] sums;
    public NumArray(int[] nums){
        sums = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            //创建从索引为1开始的数组，数组中存储的是原数组第一位到索引前一位的总和
            //举个例子：nums:[1,3,5,7,9] --> sums:[0,1,4,9,16,25]
            sums[i+1] = sums[i]+nums[i];
        }
    }
    public int sumRange(int i,int j){
        return sums[j+1]-sums[i];
    }
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
