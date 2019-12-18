package github.grapeqin.dynamicprogramming;

/**
 * 买卖股票的最佳时机 III
 *
 * @description
 * @author qinzy
 * @date 2019-12-17
 */
public class LeetCode123 {
  /**
   * 1.关于买卖股票的利润问题 不考虑其他因素，假设仅对于当前第i天来说，可以 有三种操作
   * (1)、买一股，利润为-prices[i]
   * (2)、卖一股，利润为prices[i]
   * (3)、不操作，利润为0
   *
   * 2.题目限制了最多只能拥有一股，所以还需要记录下第i天是持有1股还是持有0股，只有这两种情况，
   * 因此，我们 可以定义状态dp[i][0]和dp[i][1]：
   * dp[i][0] 表示第i天不持有股票的情况：如果是这种状态，要么前一天就已经不持有股票，要么是前一天持有一股，然后今天卖掉
   * dp[i][1] 表示第i天持有1股的情况：如果是这种情况，要么前一天就已经持有1股，要么是前一天没有持有股票，今天买一股
   * 所以可以推导出
   *
   * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
   * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
   *
   * 3.题目还限制最多只能交易2次，即买卖1次算1次交易；也可以理解为最多允许卖2次，由于卖之前一定要先买1股，最多允许卖2次意味着
   * 最多也只能买2次，买0次相当于什么也不做，对利润没有影响，我们暂不考虑，剩下买1次和买2次的情况，我们再定义一个维度，表示当前
   * 已经买了几次该股票，取值为1,2 分别表示第i天的时候已经买过1次和2次。 即dp[i][k][0]和dp[i][k][1](当然也可以是 dp[i][0][k]和dp[i][1][k])
   *
   * dp[i][k][0]                  =max(         dp[i-1][k][0],                   dp[i-1][k][1]+prices[i])
   * 第i天最多买了k次股票且当前不持有股票 =    第i-1天已经买了k次股票且不持有股票   第i-1天最多买了k次股票且持有1股，第i天卖掉
   *
   * dp[i][k][1]                  =max(         dp[i-1][k][1]                    dp[i-1][k-1][0]-prices[i])
   * 第i天最多买了k次股票且当前持有1股        第i-1天最多买了k次股票且持有1股     第i-1天最多买了k-1次股票手上没有股票，第i天买入1股，同时买入次数+1

   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
  	//参数有效性检查
  	if(prices.length == 0){
  		return 0;
	}
    // 第一维表示第i天获得的利润取值范围0~prices.length-1
    // 第二维表示已经完成了几次交易，取值范围0~2
    // 第三维表示当前是否拥有股票0~1
    int[][][] dp = new int[prices.length][3][2];
    // 只要持有股票收益就会损失当天的股价-prices[i]
    dp[0][0][1] = dp[0][2][1] = dp[0][1][1] = -prices[0];
    // 默认不进行任何交易，初始利润为0
    int maxProfix = 0;
    // i = 1 表示第2天
    int maxK = 2;
    for (int i = 1; i < prices.length; i++) {
      for (int k = 1; k <= maxK; k++) {
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
      }
    }
    int last = prices.length - 1;
    for(int k=0;k<=maxK;k++){
    	maxProfix = Math.max(maxProfix,dp[last][k][0]);
	}
    return maxProfix;
  }

  public static void main(String[] args) {
    LeetCode123 leetCode123 = new LeetCode123();
    int[] prices = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
    int maxProfit = leetCode123.maxProfit(prices);
    System.out.println("{3, 3, 5, 0, 0, 3, 1, 4} 最大利润为：" + maxProfit);
    prices = new int[] {1, 2, 3, 4, 5};
    maxProfit = leetCode123.maxProfit(prices);
    System.out.println("{1,2,3,4,5} 最大利润为:" + maxProfit);
    prices = new int[] {7, 6, 4, 3, 1};
    maxProfit = leetCode123.maxProfit(prices);
    System.out.println("{7,6,4,3,1} 最大利润为:" + maxProfit);
  }
}
