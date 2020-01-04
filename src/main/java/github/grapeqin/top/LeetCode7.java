package github.grapeqin.top;

/**
 * 整数反转
 *
 * @description
 * @author qinzy
 * @date 2020-01-04
 */
public class LeetCode7 {

  public int reverse(int x) {
    int sum = 0;
    while (x != 0) {
      int digit = x % 10;
      if (sum > Integer.MAX_VALUE / 10
          || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return 0;
      }
      if (sum < Integer.MIN_VALUE / 10
          || (sum == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
        return 0;
      }
      sum = 10 * sum + digit;
      x /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    LeetCode7 leetCode7 = new LeetCode7();
    int x = 123;
    System.out.println(leetCode7.reverse(x) == 321);

    x = -123;
    System.out.println(leetCode7.reverse(x) == -321);

    x = -120;
    System.out.println(leetCode7.reverse(x) == -21);
  }
}
