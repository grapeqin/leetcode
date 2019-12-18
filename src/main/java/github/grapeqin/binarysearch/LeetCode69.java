package github.grapeqin.binarysearch;

/**
 * x的平方根
 *
 * @description
 * @author qinzy
 * @date 2019-12-11
 */
public class LeetCode69 {

  /**
   * 求x的平方根，忽略小数位 思路：参考二分查找的代码模板：定义left=0,right=x， 当left<right时依次迭代尝试，直到查找到目标值
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

  /**
   * 求x的平方根，使用牛顿法 看推导之前，请先了解导数的基本定义和牛顿法的基本概念之后再来推导计算x的公式 根据导数的公式斜率F(x0) = f(x0) / xi - x0 若 F(xi)
   * 约等于0，要找到这个xi 则 xi = f(x0) / F(x0) + x0 同时 f(x) = x的平方 - a(初始值x0) 且 平方根的斜率为2 所以 xi = (x0+a/x0) /
   * 2
   *
   * @param x
   * @return
   */
  public int mySqrt(long x) {
    long a = x;
    while (x * x > a) {
      x = (x + a / x) / 2;
    }
    return (int) x;
  }

  public double mySqrt(long x, double precision) {
  	double dx = x;
    double a = dx;
    while (Math.abs(dx * dx - a) > precision) {
      dx = (dx + a / dx) / 2;
    }
    return dx;
  }

  public double mySqrt(double x, double precision) {
    double left = 0, right = x, mid = (left + right) / 2.0;
    while (Math.abs(x - mid * mid) > precision) {
      if (mid > x / mid) {
        right = mid;
      } else {
        left = mid;
      }
      mid = (left + right) / 2.0;
    }
    return mid;
  }

  public static void main(String[] args) {
    LeetCode69 leetCode69 = new LeetCode69();
    double x = 2.0;
    double precision = 1e-10;
    System.out.println(leetCode69.mySqrt(x, precision));
    System.out.println(Math.sqrt(2));
    System.out.println(leetCode69.mySqrt(2,precision));
  }
}
