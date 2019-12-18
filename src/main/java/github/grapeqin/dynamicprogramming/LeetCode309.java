package github.grapeqin.dynamicprogramming;

/**
 * 最佳买卖股票时机含冷冻期
 * @description
 * @author qinzy
 * @date 2019-12-18
 */
public class LeetCode309 {
  /**
   * 一、DP状态定义 dp[i][k][0] 表示第i天交易了k次不持有股票的收益 dp[i][k][1] 表示第i天交易了k次持有1股的收益
   *
   * 二、通用的 DP状态转移方程如下
   * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
   * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
   *
   * 三、这道题加入了1天冷冻期,但是对股票卖出没有做任何限制,只是限制了买入股票的时机, 重点看dp[i][k][1] 这个DP方程
   * dp[i][k][1] = max(dp[i-1][k][1],dp[i-2][k-1][0]-prices[i])
   * 上面这个递推公式可以理解为 如果第i天已经买了k次并且持有1股的收益 = max(第i-1天已经买了k次并且持有1股的收益,第i-2天买了一股并持有到第i天)
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    // 参数有效性检查
    if (prices.length <= 1) {
      return 0;
    }

    // 第一维表示第i天获得的利润取值范围0~prices.length-1
    // 第二维表示当前是否拥有股票0~1
    int[][] dp = new int[prices.length][2];
    // 只要持有股票收益就会损失当天的股价-prices[i]
    dp[0][1] = -prices[0];
    // 只有一种情况就是第0天买入,第1天卖出了
    dp[1][0] = Math.max(0,prices[1] - prices[0]);
    // 第1天持有1股,要么是第0天就持有1股,要么是第0天没有操作第1天持有一股
    dp[1][1] = Math.max(-prices[0], -prices[1]);

    for (int i = 2; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
    }
    return dp[prices.length - 1][0];
  }

  public static void main(String[] args) {
    LeetCode309 leetCode309 = new LeetCode309();
    int[] prices = new int[] {1, 2, 3, 0, 2};
    System.out.println("{1,2,3,0,2} 最大利润为: " + leetCode309.maxProfit(prices));

    prices = new int[] {1, 2, 4};
    System.out.println("{1,2,4} 最大利润为: " + leetCode309.maxProfit(prices));

    prices = new int[] {2, 1, 4};
    System.out.println("{2,1,4} 最大利润为: " + leetCode309.maxProfit(prices));

    prices = new int[] {2, 1};
    System.out.println("{2,1} 最大利润为: " + leetCode309.maxProfit(prices));

    prices = new int[] {1, 2};
    System.out.println("{1,2} 最大利润为: " + leetCode309.maxProfit(prices));
  }
}
