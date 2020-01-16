package leetcode.动态规划;

/**
 * @auther Summerday
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    //动态规划之爬楼梯
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            //
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
