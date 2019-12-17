package github.grapeqin.dynamicprogramming;

/**
 * 乘积最大子序列
 *
 * @description
 * @author qinzy
 * @date 2019-12-17
 */
public class LeetCode152 {

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    // length = 2的二维数组
    // 第0行的第0列 表示当前位置的最小值,第1列表示当前位置的最大值
    // 第1行 用于反转
    int[][] ans = new int[2][2];
    ans[0][0] = nums[0];
    ans[0][1] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int last = (i - 1) % 2;
      int cur = i % 2;
      int num = nums[i];
      ans[cur][0] = Math.min(num > 0 ? num * ans[last][0] : num * ans[last][1], num);
      ans[cur][1] = Math.max(num > 0 ? num * ans[last][1] : num * ans[last][0], num);
      max = Math.max(Math.max(ans[cur][1], ans[last][1]), max);
    }
    return max;
  }

  public static void main(String[] args) {
    LeetCode152 leetCode152 = new LeetCode152();
    int[] nums = new int[] {2, 3, -2, 4};
    int max = leetCode152.maxProduct(nums);
    System.out.println("the subarray string max is : " + max);

    nums = new int[] {-2, 0, -1};
    max = leetCode152.maxProduct(nums);
    System.out.println("the subarray string max is : " + max);
  }
}
