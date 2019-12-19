package github.grapeqin.dynamicprogramming;

import java.util.Arrays;

/**
 * 最长上升子数组
 *
 * @description
 * @author qinzy
 * @date 2019-12-19
 */
public class LeetCode300_02 {

  /**
   * 动态规划 1、DP状态定义
   *
   * dp[i] 表示包含第i个元素时的最长子数组长度
   *
   * 2、状态转移方程
   * 只要 num[i-1] < num[i] 那么 dp[i] = dp[i-1]+1
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
    if (nums.length < 1) {
      return 0;
    }

    int[] dp = new int[nums.length];
    // 初始每个位置的最长子数组加上自身都是1
    Arrays.fill(dp, 1);

    int ans = 1;
    for (int i = 1; i < nums.length; i++) {
    	if(nums[i-1] < nums[i]){
    		dp[i] = dp[i-1]+1;
		}
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode300_02 leetCode300 = new LeetCode300_02();
    int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println("{10,9,2,5,3,7,101,18} 最长上升子数组为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {};
    System.out.println("{} 最长上升子数组为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {1};
    System.out.println("{1} 最长上升子数组为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {1, 2, 3, 4, 5, 6};
    System.out.println("{1,2,3,4,5,6} 最长上升子数组为 : " + leetCode300.lengthOfLIS(nums));

    nums = new int[] {6, 5, 4, 3, 2, 1};
    System.out.println("{6, 5, 4, 3, 2, 1} 最长上升子数组为 : " + leetCode300.lengthOfLIS(nums));
  }
}
