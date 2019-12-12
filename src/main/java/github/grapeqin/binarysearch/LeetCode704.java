package github.grapeqin.binarysearch;

/**
 * 二分查找
 *
 * @description
 * @author qinzy
 * @date 2019-12-12
 */
public class LeetCode704 {

  public int search(int[] nums, int target) {
    if (0 == nums.length) {
      return -1;
    }
    int start = 0, end = nums.length - 1;
    while (start < end) {
      int mid = (start + end + 1) >>> 1;
      if (target < nums[mid]) {
        end = mid - 1;
      } else {
        start = mid;
      }
    }
    if (target == nums[start]) {
      return start;
    }
    return -1;
  }

  public static void main(String[] args) {
    LeetCode704 leetCode704 = new LeetCode704();
    int[] nums = new int[] {-1, 0, 3, 5, 9, 12};
    int target = 9;
    System.out.println(leetCode704.search(nums, target));

    nums = new int[] {-1, 0, 3, 5, 9, 12};
    target = 2;
    System.out.println(leetCode704.search(nums, target));
  }
}
