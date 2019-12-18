package github.grapeqin.dynamicprogramming;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @description
 * @author qinzy
 * @date 2019-12-18
 */
public class LeetCode714 {

  /**
   * 分析:
   * 1、DP状态定义
   * dp[i][0] 表示第i天时不持有股票时的收益
   * dp[i][1] 表示第i天持有1股的收益
   *
   * 2、DP状态转移方程
   * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i]-fee)
   * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
   * @param prices
   * @param fee
   * @return
   */
  public int maxProfit(int[] prices, int fee) {
    if (prices.length <= 1) {
      return 0;
    }
    int[][] dp = new int[prices.length][2];
    // 初始化
    dp[0][1] = -prices[0];
    int maxProfit = Integer.MIN_VALUE;
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
      // 由于有手续费存在，可能持有股票获利更大
      maxProfit = Math.max(maxProfit, Math.max(dp[i][0], dp[i][1]));
    }
    return maxProfit;
  }

  public static void main(String[] args){
  	LeetCode714 leetCode714 = new LeetCode714();
    int[] prices = new int[] {1, 3, 2, 8, 4, 9};
    System.out.println("{1, 3, 2, 8, 4, 9} fee = 0 最大利润为 : " + leetCode714.maxProfit(prices, 0));
    System.out.println("{1, 3, 2, 8, 4, 9} fee = 2 最大利润为 : " + leetCode714.maxProfit(prices, 2));
    System.out.println("{1, 3, 2, 8, 4, 9} fee = 4 最大利润为 : " + leetCode714.maxProfit(prices, 4));
  }
}
