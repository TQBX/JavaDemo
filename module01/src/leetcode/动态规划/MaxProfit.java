package leetcode.动态规划;

/**
 * @auther Summerday
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    //动态规划，假设当前为第i天
    //假设在price[i]天卖出，想获得最大利益，一定是第i天之前的最低价格买入,minPrice，此时收益为prices[i]-minPrice
    //假设没有在prices[i]天卖出，说明，第i天的最大收益等于前i-1天中的最大收益
    //第i天最大收益=max（第i天卖出所得的收益，前i-1天的最大收益）
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i<prices.length;i++){
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(prices[i]-minPrice,maxProfit);
        }
        return maxProfit;

    }
}
