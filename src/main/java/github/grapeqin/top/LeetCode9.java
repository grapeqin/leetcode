package github.grapeqin.top;

/**
 * 回文数
 *
 * @description
 * @author qinzy
 * @date 2020-05-17
 */
public class LeetCode9 {

  /**
   * 将数字折半
   *
   * @param x
   * @return
   */
  public boolean isPalindrome(int x) {
    if (x < 0 || x % 10 == 0 && x != 0) {
      return false;
    }
    int reverseX = 0;
    while (x > reverseX) {
      reverseX = reverseX * 10 + x % 10;
      x /= 10;
    }
    return x == reverseX || x == reverseX / 10;
  }

  public static void main(String[] args) {
    LeetCode9 leetCode9 = new LeetCode9();
    int x = -121;
    System.out.println(leetCode9.isPalindrome(x));

    x = 10;
    System.out.println(leetCode9.isPalindrome(x));

    x = 121;
    System.out.println(leetCode9.isPalindrome(x));
  }
}
