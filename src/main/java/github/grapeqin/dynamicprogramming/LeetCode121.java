package github.grapeqin.dynamicprogramming;

/**
 * 买卖股票的最佳时机
 *
 * @description
 * @author qinzy
 * @date 2019-12-18
 */
public class LeetCode121 {
  /**
   * 分析:
   * 最多交易1次，为了获取最大利润其实就是在最低点买入然后最高点抛出
   * 定义股票价格最低点min和最高利润max，初始可以假设第0天就是价格最低点min=prices[0]，最高利润为max=0
   * 从第1天开始，如果prices[i] < prices[i-1] 说明今天的价格比前一天低，取当前股价最低点和prices[i]的极小值
   * 否则，说明今天卖出会获利，可以取 prices[i]-min 的利润与当前利润的极大值
   *
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int min = prices[0];
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[i - 1]) {
        min = Math.min(min, prices[i]);
      }
      max = Math.max(max, prices[i] - min);
    }
    return max;
  }

  /**
   * 动态规划(通用版本)
   * 请参考LeetCode123说明
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int maxK = 1;
    int[][][] dp = new int[prices.length][maxK+1][2];
    //持有股票收益为负
    dp[0][0][1] = dp[0][1][1] = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      for (int k = 1; k <= maxK; k++) {
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
      }
    }
    return dp[prices.length - 1][maxK][0];
  }

  /**
   * 动态规划
   * 我们发现K=1,拿掉K的这层迭代，直接硬编码
   *
   * @param prices
   * @return
   */
  public int maxProfit3(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int[][][] dp = new int[prices.length][2][2];
    // 持有股票收益为负
    dp[0][0][1] = dp[0][1][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
      dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
    }
    return dp[prices.length - 1][1][0];
  }

  /**
   * 动态规划，状态简化后的版本
   *
   * 对于dp[i][0][0] 表示第i天的时候没有进行过交易且当前不持有股票，也就是第i天之前什么也没做，第i天也什么都不做
   * 那么其利润为0
   *
   * 通过迭代公式，我们可以发现，整个迭代过程其实就是dp[i][1][0]和dp[i][1][1] 在不停的迭代 而且我们也不需要
   * 运算的中间结果，只需要记录最后一次的迭代结果即可
   *
   * 令 dp0 = dp[i][1][0] dp1 = dp[i][1][1]
   *
   * @param prices
   * @return
   */
  public int maxProfit4(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    // 持有股票收益为负
    int dp0 = 0,dp1 = -prices[0];
    for (int i = 1; i < prices.length; i++) {
		dp0 = Math.max(dp0, dp1 + prices[i]);
		dp1 = Math.max(dp1, - prices[i]);
    }
    return dp0;
  }

  public static void main(String[] args) {
    LeetCode121 leetCode121 = new LeetCode121();
    int[] prices = new int[] {7, 1, 5, 3, 6, 4};
    System.out.println("{7,1,5,3,6,4} 利润最大值为 : " + leetCode121.maxProfit1(prices));
    System.out.println("{7,1,5,3,6,4} 利润最大值为 : " + leetCode121.maxProfit2(prices));
    System.out.println("{7,1,5,3,6,4} 利润最大值为 : " + leetCode121.maxProfit3(prices));
    System.out.println("{7,1,5,3,6,4} 利润最大值为 : " + leetCode121.maxProfit4(prices));

    prices = new int[] {7, 6, 4, 3, 1};
    System.out.println("{7,6,4,3,1} 利润最大值为 : " + leetCode121.maxProfit1(prices));
    System.out.println("{7,6,4,3,1} 利润最大值为 : " + leetCode121.maxProfit2(prices));
    System.out.println("{7,6,4,3,1} 利润最大值为 : " + leetCode121.maxProfit3(prices));
    System.out.println("{7,6,4,3,1} 利润最大值为 : " + leetCode121.maxProfit4(prices));

    prices = new int[] {1};
    System.out.println("{1} 利润最大值为 : " + leetCode121.maxProfit1(prices));
    System.out.println("{1} 利润最大值为 : " + leetCode121.maxProfit2(prices));
    System.out.println("{1} 利润最大值为 : " + leetCode121.maxProfit3(prices));
    System.out.println("{1} 利润最大值为 : " + leetCode121.maxProfit4(prices));

    prices = new int[] {2, 4, 1};
    System.out.println("{2,4,1} 利润最大值为 : " + leetCode121.maxProfit1(prices));
    System.out.println("{2,4,1} 利润最大值为 : " + leetCode121.maxProfit2(prices));
    System.out.println("{2,4,1} 利润最大值为 : " + leetCode121.maxProfit3(prices));
    System.out.println("{2,4,1} 利润最大值为 : " + leetCode121.maxProfit4(prices));

    prices = new int[] {1, 2};
    System.out.println("{1,2} 利润最大值为 : " + leetCode121.maxProfit1(prices));
    System.out.println("{1,2} 利润最大值为 : " + leetCode121.maxProfit2(prices));
    System.out.println("{1,2} 利润最大值为 : " + leetCode121.maxProfit3(prices));
    System.out.println("{1,2} 利润最大值为 : " + leetCode121.maxProfit4(prices));
  }
}
