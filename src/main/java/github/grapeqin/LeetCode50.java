package github.grapeqin;

/**
 * Pow(x,n)
 *
 * @description
 * @author qinzy
 * @date 2019-12-24
 */
public class LeetCode50 {

  public double pow(double x, int n) {
    // 注意处理n < 0的情况
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    return recurse(x, n);
  }

  private double recurse(double x, int n) {
    // 递归结束条件
    if (n == 0) {
      return 1;
    }
    // 递归下一层
    double res = recurse(x, n >> 1);
    // 下层递归返回后的处理
    if ((n & 1) == 0) {
      res = res * res;
    } else {
      res = x * res * res;
    }
    return res;
  }

  /**
   * 迭代法求pow(x,n)
   *
   * @param x
   * @param n
   * @return
   */
  public double pow1(double x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    double ans = 1, cur = x;
    while (n > 0) {
      if ((n & 1) == 1) {
        ans = ans * cur;
      }
      cur = cur * cur;
      n >>= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode50 leetCode50 = new LeetCode50();
    double x = 0.0;
    int n = -1;
    System.out.println(leetCode50.pow(x, n) == leetCode50.pow1(x, n));

    x = -2;
    System.out.println(leetCode50.pow(x, n) == leetCode50.pow1(x, n));

    x = 1;
    System.out.println(leetCode50.pow(x, n) == leetCode50.pow1(x, n));

    n = 0;
    System.out.println(leetCode50.pow(x, n) == leetCode50.pow1(x, n));

    n = 2;
    System.out.println(leetCode50.pow(x, n) == leetCode50.pow1(x, n));
  }
}
