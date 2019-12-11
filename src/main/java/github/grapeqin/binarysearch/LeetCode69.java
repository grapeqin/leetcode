package github.grapeqin.binarysearch;

/**
 * x的平方根 思路：参考二分查找的代码模板：定义left=0,right=x， 当left<right时依次迭代尝试，直到查找到目标值
 *
 * @description
 * @author qinzy
 * @date 2019-12-11
 */
public class LeetCode69 {

  /**
   * 求x的平方根，忽略小数位
   *
   * @param x 任意非负整数
   * @return
   */
  public int mySqrt(int x) {
    int left = 0, right = x, mid;
    while (left < right) {
      // 注意求中位数时左右边界累加越界问题,+1表示在只有两个元素时，mid为右中位数
      mid = (left + right + 1) >>> 1;
      if (mid > x / mid) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return left;
  }
}
