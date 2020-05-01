package github.grapeqin.top;

/**
 * 最长回文子串
 *
 * @description
 * @author qinzy
 * @date 2020-05-01
 */
public class LeetCode5_1 {
  /**
   * 中心扩散法
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    String ans = "";
    if (null == s || s.length() < 1) {
      return ans;
    }
    for (int i = 0; i < s.length(); i++) {
      int n1 = searchLongestPalindrome(s, i, i);
      int n2 = searchLongestPalindrome(s, i, i + 1);
      int n = Math.max(n1, n2);
      if (n > ans.length()) {
        int left = i - (n - 1) / 2;
        int right = i + n / 2;
        ans = s.substring(left, right + 1);
      }
    }
    return ans;
  }

  /**
   * 以(i,j)为中心扩散查找回文字符串
   *
   * @param s
   * @param i
   * @param j
   * @return
   */
  private int searchLongestPalindrome(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    return j - i - 1;
  }

  public static void main(String[] args) {
    LeetCode5_1 leetCode5 = new LeetCode5_1();
    String s = "babad";
    System.out.println(leetCode5.longestPalindrome(s).equals("bab"));

    s = "cbbd";
    System.out.println(leetCode5.longestPalindrome(s).equals("bb"));
  }
}
