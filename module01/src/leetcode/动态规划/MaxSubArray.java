package leetcode.动态规划;

/**
 * @auther Summerday
 */
public class MaxSubArray {


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    //动态规划
    public static int maxSubArray(int[] nums){
        int sum = 0;
        int target = nums[0];
        for(int num:nums){
            //sum>0 增益效果，保留sum并加上当前遍历数字
            if(sum>0){
                sum+=num;
            //sum<=0 无增益效果，直接舍弃，并将sum更新为当前遍历数字
            }else{
                sum = num;
            }
            //比较sum和target的大小，将最大值设为target
            target = Math.max(target, sum);
        }

        return target;
    }

}



