package github.grapeqin.dynamicprogramming;

/**
 * 编辑距离
 *
 * @description
 * @author qinzy
 * @date 2019-12-19
 */
public class LeetCode72 {
  /**
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance(String word1, String word2) {
    if (null == word1 || null == word2) {
      return 0;
    }
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];

    // 初始化
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    LeetCode72 leetCode72 = new LeetCode72();
    String word1 = "horse";
    String wold2 = "ros";
    System.out.println(
        String.format("%s 转换成 %s 最少需要 %d 步", word1, wold2, leetCode72.minDistance(word1, wold2)));

    word1 = "intention";
    wold2 = "execution";
    System.out.println(
        String.format("%s 转换成 %s 最少需要 %d 步", word1, wold2, leetCode72.minDistance(word1, wold2)));
  }
}
