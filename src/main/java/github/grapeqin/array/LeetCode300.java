package github.grapeqin.array;


import java.util.Arrays;

/**
 * 最长上升子序列<br/>
 * 动态规划解法,时间复杂度O(N^2)<br/>
 * 定义dp[i]表示以nums[0,i]范围内的数组最长上升子序列数量,
 * 那么当 nums[j] < nums[i] 则 dp[i] = dp[j] + 1
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[i]);
        }
        return dp[0];
    }
}
