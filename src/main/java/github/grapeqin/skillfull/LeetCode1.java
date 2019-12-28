package github.grapeqin.skillfull;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @description
 * @author qinzy
 * @date 2019-12-24
 */
public class LeetCode1 {

  /**
   * 借助于map结构，时间复杂度O(n)
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> table = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      int num = target - nums[i];
      if (table.containsKey(num)) {
        return new int[] {table.get(num), i};
      }
      // 将当前元素放入hash表
      table.put(nums[i], i);
    }
    return null;
  }

  /**
   * 暴力解法时间复杂度N的平方
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum2(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }
}
