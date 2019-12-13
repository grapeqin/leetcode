package github.grapeqin.bit;

import java.util.Arrays;

/**
 * 比特位计数
 *
 * @description
 * @author qinzy
 * @date 2019-12-13
 */
public class LeetCode338 {

  /**
   * 解法1： 对任一个非负整数来说，为奇数或偶数， 经过分析可得 对于奇数，其二进制位中1的个数为前面一个偶数二进制位中1的个数+1
   * 对于偶数n，其二进制位中1的个数总是等于n/2这个数中二进制位中1的个数
   *
   * @param num
   * @return
   */
  public int[] countBits1(int num) {
    int[] ans = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      if ((i & 1) == 1) {
        ans[i] = ans[i - 1] + 1;
      } else {
        ans[i] = ans[i >>> 1];
      }
    }
    return ans;
  }

  /**
   * 解法2： 对任一个非负整数n，它的二进制位中1的个数为n右移一位，然后在判断n为奇数还是偶数，为奇数就+1
   *
   * <p>即f(n) = f(n>>>1)+ (n&1)
   *
   * @param num
   * @return
   */
  public int[] countBits2(int num) {
    int[] ans = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      ans[i] = ans[i >>> 1] + (i & 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode338 leetCode338 = new LeetCode338();
    int n = 10;
    Arrays.stream(leetCode338.countBits1(n)).skip(1).forEach((x) -> System.out.print(x + ","));
    System.out.println();
    Arrays.stream(leetCode338.countBits2(n)).skip(1).forEach((x) -> System.out.print(x + ","));
  }
}
