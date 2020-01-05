package github.grapeqin.top;

/**
 * 最长回文子串
 *
 * @description
 * @author qinzy
 * @date 2020-01-05
 */
public class LeetCode5 {
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
      String str1 = searchLongestPalindrome(s, i, i);
      String str2 = searchLongestPalindrome(s, i, i + 1);
      String str = str1.length() > str2.length() ? str1 : str2;
      if (str.length() > ans.length()) {
        ans = str;
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
  private String searchLongestPalindrome(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    return s.substring(i + 1, j);
  }

  public static void main(String[] args) {
    LeetCode5 leetCode5 = new LeetCode5();
    String s = "babad";
    System.out.println(leetCode5.longestPalindrome(s).equals("bab"));

    s = "cbbd";
    System.out.println(leetCode5.longestPalindrome(s).equals("bb"));
  }
}
