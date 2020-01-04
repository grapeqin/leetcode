package github.grapeqin.top;

/**
 * 字符串转换成整数(atoi)
 *
 * @description
 * @author qinzy
 * @date 2020-01-04
 */
public class LeetCode8 {
  /**
   * @param str
   * @return
   */
  public int myAtoi(String str) {
    int sum = 0, sign = 1, index = 0;
    // 1.处理空格
    str = str.trim();
    // 2.处理正负号
    if (str.length() > index && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
      sign = str.charAt(index++) == '+' ? 1 : -1;
    }
    // 3.迭代取整数
    while (index < str.length()) {
      // 索引要叠加
      int digit = str.charAt(index++) - '0';
      if (digit < 0 || digit > 9) {
        // 返回值记得乘以正负号
        return sum * sign;
      }
      // 4.处理溢出
      if (sum > Integer.MAX_VALUE / 10
          || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      sum = sum * 10 + digit;
    }
    return sum * sign;
  }

  public static void main(String[] args) {
    LeetCode8 leetCode8 = new LeetCode8();
    String str = "42";
    System.out.println(leetCode8.myAtoi(str) == 42);

    str = "   -42";
    System.out.println(leetCode8.myAtoi(str) == -42);

    str = " -4193 with words";
    System.out.println(leetCode8.myAtoi(str) == -4193);

    str = "words and 987";
    System.out.println(leetCode8.myAtoi(str) == 0);

    str = "-91283472332";
    System.out.println(leetCode8.myAtoi(str) == -2147483648);
  }
}
