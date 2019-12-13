package github.grapeqin.bit;

/**
 * 数二进制位1的个数
 *
 * <p>n 为无符号的整数
 *
 * @description
 * @author qinzy
 * @date 2019-12-13
 */
public class LeetCode191 {

  public int hammingWeight1(int n) {
    int ans = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        ans++;
      }
      n >>>= 1;
    }
    return ans;
  }

  public int hammingWeight2(int n) {
    int ans = 0;
    while (n != 0) {
      ans++;
      n &= (n - 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode191 leetCode191 = new LeetCode191();
    int n = 5;
    System.out.println(leetCode191.hammingWeight1(n) == leetCode191.hammingWeight2(n));
    n = 10;
    System.out.println(leetCode191.hammingWeight1(n) == leetCode191.hammingWeight2(n));
  }
}
