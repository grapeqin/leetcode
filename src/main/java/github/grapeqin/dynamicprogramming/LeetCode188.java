package github.grapeqin.dynamicprogramming;

/**
 * 买卖股票的最佳时机 IV
 * @description
 * @author qinzy
 * @date 2019-12-18
 */
public class LeetCode188 {

  /**
   * 动态规划
   * 思路:
   * 1、由于最多只能持有1股,对于prices数组来说,最多只能交易prices.length/2次
   * 当 K > prices.length/2时，其实就类似LeetCode122,交易次数可以理解为没有限制了
   * 当 K <= prices.length/2时，进行枚举
   *
   * 2、DP状态定义
   *
   * dp[i][k][0]和dp[i][k][1] 具体含义不再赘述，请参考LeetCode121、LeetCode122、LeetCode123说明
   *
   *
   *
   * @param k
   * @param prices
   * @return
   */
  public int maxProfit(int k, int[] prices) {
    // 参数有效性检查
    if (prices.length <= 1) {
      return 0;
    }
    if (k > prices.length / 2) {
      return maxProfitWithInfinityK(prices);
    }
    // 第一维表示第i天获得的利润取值范围0~prices.length-1
    // 第二维表示已经完成了几次交易，取值范围0~k
    // 第三维表示当前是否拥有股票0~1
    int[][][] dp = new int[prices.length][k + 1][2];
    // 只要持有股票收益就会损失当天的股价-prices[i]
    for (int i = 0; i < k + 1; i++) {
      dp[0][i][1] = -prices[0];
    }
    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j <= k; j++) {
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
      }
    }
    int maxProfix = 0;
    int last = prices.length - 1;
    for (int i = 0; i <= k; i++) {
      maxProfix = Math.max(maxProfix, dp[last][i][0]);
    }
    return maxProfix;
  }

  private int maxProfitWithInfinityK(int[] prices){
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

  public static void main(String[] args) {
    LeetCode188 leetCode188 = new LeetCode188();
    int[] prices = new int[] {2, 4, 1};
    System.out.println("{2,4,1} k = 0 最大利润为 : " + leetCode188.maxProfit(0, prices));
    System.out.println("{2,4,1} k = 1 最大利润为 : " + leetCode188.maxProfit(1, prices));
    System.out.println("{2,4,1} k = 2 最大利润为 : " + leetCode188.maxProfit(2, prices));
    System.out.println("{2,4,1} k = 3 最大利润为 : " + leetCode188.maxProfit(3, prices));

    prices = new int[]{3,2,6,5,0,3};
    System.out.println("{3,2,6,5,0,3} k = 1 最大利润为 : " + leetCode188.maxProfit(1, prices));
    System.out.println("{3,2,6,5,0,3} k = 2 最大利润为 : " + leetCode188.maxProfit(2,prices));
    System.out.println("{3,2,6,5,0,3} k = 4 最大利润为 : " + leetCode188.maxProfit(4,prices));

  }
}
