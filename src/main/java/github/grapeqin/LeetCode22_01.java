package github.grapeqin;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成有效括号对 定义好递归结束条件和递归条件
 *
 * @description
 * @author qinzy
 * @date 2019-12-14
 */
public class LeetCode22_01 {

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    dfs(n, n, ans, "");
    return ans;
  }

  /**
   * @param usedLeft 还可以放置左括号的数量
   * @param usedRight 还可以放置右括号的数量
   * @param ans 保存结果的集合
   * @param str 拼装括号的临时字符串
   */
  private void dfs(int usedLeft, int usedRight, List<String> ans, String str) {
    // 递归结束条件
    if (0 == usedLeft && 0 == usedRight) {
      ans.add(str);
      return;
    }
    if (usedLeft > 0) {
      dfs(usedLeft - 1, usedRight, ans, str + "(");
    }
    // 右括号还可以放置的数量
    if (usedRight > usedLeft) {
      dfs(usedLeft, usedRight - 1, ans, str + ")");
    }
  }

  public static void main(String[] args) {
    LeetCode22_01 leetCode2201 = new LeetCode22_01();
    int n = 3;
    List<String> ans = leetCode2201.generateParenthesis(n);
    ans.forEach((x) -> System.out.println(x));

    n =2;
    System.out.println("1 << n : " +  ((1 << n)-1));
  }
}
