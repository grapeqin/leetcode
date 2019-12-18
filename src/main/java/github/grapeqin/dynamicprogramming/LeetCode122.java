package github.grapeqin.dynamicprogramming;

/**
 * 买卖股票的最佳时机II
 *
 * @description
 * @author qinzy
 * @date 2019-12-18
 */
public class LeetCode122 {

  /**
   * 贪心算法 由于这道题没有限制交易的次数,我们可以假设只要今天的股价高于昨天的股价,
   * 那么昨天买今天卖一定能获利 累加所有的获利即是最终可以获得的最大利润
   *
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }

  /**
   * 动态规划
   *
   * <p>思路清参考LeetCode123,递推方程为
   *
   * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
   * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
   *
   * 由于没有限制交易次数,假设k为无穷大,那么可以近似的认为 dp[i-1][k][0] = dp[i-1][k-1][0]
   *
   * 令 dp0 = dp[i][k][0] dp1 = dp[i][k][1]
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    // 持有股票收益为负
    int dp0 = 0, dp1 = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp0 = Math.max(dp0, dp1 + prices[i]);
      dp1 = Math.max(dp1, dp0 - prices[i]);
    }
    return dp0;
  }

  public static void main(String[] args){
    LeetCode122 leetCode122 = new LeetCode122();
    int[] prices = new int[] {7, 1, 5, 3, 6, 4};
    System.out.println("{7,1,5,3,6,4} 最大利润为 : " + leetCode122.maxProfit1(prices));
    System.out.println("{7,1,5,3,6,4} 最大利润为 : " + leetCode122.maxProfit2(prices));

    prices = new int[] {1, 2, 3, 4, 5};
    System.out.println("{1,2,3,4,5} 最大利润为 : " + leetCode122.maxProfit1(prices));
    System.out.println("{1,2,3,4,5} 最大利润为 : " + leetCode122.maxProfit2(prices));

    prices = new int[] {7, 6, 4, 3, 1};
    System.out.println("{7,6,4,3,1} 最大利润为 : " + leetCode122.maxProfit1(prices));
    System.out.println("{7,6,4,3,1} 最大利润为 : " + leetCode122.maxProfit2(prices));
  }

}
