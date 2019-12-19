package github.grapeqin.dynamicprogramming;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @description
 * @author qinzy
 * @date 2019-12-19
 */
public class LeetCode322 {
  /**
   * 动态规划 思路: 可以将这道题类比为爬楼梯,比如一共amount级台阶,每步可以有多种走法,问最后走完amount 级台阶最少的步数
   *
   * <p>1、DP状态定义
   *
   * <p>dp[i]表示走到第i级台阶最少的步数
   *
   * <p>2、DP方程 dp[i] = min(dp[i-coins[j]]+1)
   *
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    if (coins.length < 1 || amount < 1) {
      return -1;
    }
    int[] dp = new int[amount + 1];
    //初始化一个比目标值大的值，最后可以借助这个来判断当前这一位是否有最优解
    Arrays.fill(dp, amount + 1);
    //必须初始化
    dp[0] = 0;
    // 初始化
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    LeetCode322 leetCode322 = new LeetCode322();
    int[] coins = new int[] {1, 2, 5};
    System.out.println(
        "{1,2,5} coins change amount 11 min steps is : " + leetCode322.coinChange(coins, 11));

    coins = new int[] {2};
    System.out.println(
        "{2} coins change amount 3 min steps is : " + leetCode322.coinChange(coins, 3));
  }
}
