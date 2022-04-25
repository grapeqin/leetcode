package github.grapeqin.array;

/**
 * 解法1:暴力解法,定义i表示数组中元素的下标,依次遍历以i开头的所有子数组的和,取最大值即可。时间复杂度O(N^2)
 * 解法2:动态规划,定义状态转移方程 dp[i] = Math.max(dp[i-1]+nums[i],nums[i])。时间复杂度为O(N),空间复杂度为O(1)
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max,dp;
        max = dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp+nums[i],nums[i]);
            max = Math.max(dp,max);
        }
        return max;
    }
}
