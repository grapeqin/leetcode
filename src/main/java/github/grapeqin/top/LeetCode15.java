package github.grapeqin.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * 本题的难点在如何过滤重复结果
 * 1、处理第1个数的重复
 * 2、处理第2、3个数的重复
 *
 * @description
 * @author qinzy
 * @date 2020-01-06
 */
public class LeetCode15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums.length < 3) {
      return ans;
    }
    // 排序
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      // 过滤第1个数重复的结果
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
          // 过滤第二个数重复的结果
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          // 过滤第三个数重复的结果
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode15 leetCode15 = new LeetCode15();
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> ans = leetCode15.threeSum(nums);
    ans.forEach((x) -> System.out.println(x));
  }
}
