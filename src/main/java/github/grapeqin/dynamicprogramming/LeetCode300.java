package github.grapeqin.dynamicprogramming;

import java.util.Arrays;

/**
 * 最长上升子序列
 *
 * @description
 * @author qinzy
 * @date 2019-12-19
 */
public class LeetCode300 {

  /**
   * 动态规划 1、DP状态定义
   *
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
    if (nums.length < 1) {
      return 0;
    }
    int[] dp = new int[nums.length];
    // 初始每个位置的最长子序列加上自身都是1
    Arrays.fill(dp, 1);
    int ans = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode300 leetCode300 = new LeetCode300();
    int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println("{10,9,2,5,3,7,101,18} 最长上升子序列为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {};
    System.out.println("{} 最长上升子序列为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {1};
    System.out.println("{1} 最长上升子序列为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {1, 2, 3, 4, 5, 6};
    System.out.println("{1,2,3,4,5,6} 最长上升子序列为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {6, 5, 4, 3, 2, 1};
    System.out.println("{6, 5, 4, 3, 2, 1} 最长上升子序列为 : " + leetCode300.lengthOfLIS(nums));
  }
}
