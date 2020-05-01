package github.grapeqin.top;

/**
 * 最长回文子串
 *
 * @description
 * @author qinzy
 * @date 2020-05-01
 */
public class LeetCode5_2 {
  /**
   * 中心扩散法
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    if (null == s) {
      return null;
    }
    String res = null;
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (int i = n - 1; i >= 0; i--) {

      for (int j = i; j < n; j++) {

        // 包含了初始化dp数组和递推方程两个步骤
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

        // 找到最长的回文子串就更新结果字符串
        if (dp[i][j] && (null == res || j - i + 1 > res.length())) {
          res = s.substring(i, j + 1);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    LeetCode5_2 leetCode5 = new LeetCode5_2();
    String s = "babad";
    System.out.println(
        leetCode5.longestPalindrome(s).equals("bab")
            || leetCode5.longestPalindrome(s).equals("aba"));

    s = "cbbd";
    System.out.println(leetCode5.longestPalindrome(s).equals("bb"));
  }
}
