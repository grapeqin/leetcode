package github.grapeqin.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过位运算解决N皇后问题
 *
 * @description
 * @author qinzy
 * @date 2019-12-16
 */
public class LeetCode51 {

  private int n;

  public List<List<String>> resolveNQueen(int n) {
    this.n = n;
    List<List<String>> result = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    dfs(0, 0, 0, 0, ans, result);
    return result;
  }

  private void dfs(int row, int col, int pie, int na, List<String> ans, List<List<String>> result) {
    if (row >= n) {
      result.add(new ArrayList<>(ans));
      return;
    }
    // 获取当前行所有可以放皇后的位置
    int bits = ~(col | pie | na) & ((1 << n) - 1);
    while (bits > 0) {
      // 获取最右边的一个空位置
      int bit = bits & -bits;
      String str = generate(bit);
      ans.add(str);
      dfs(row + 1, col | bit, (pie | bit) << 1, (na | bit) >> 1, ans, result);
      ans.remove(str);
      // 移除最右边的一个空位置
      bits &= bits - 1;
    }
  }

  private String generate(int bit) {
    char[] chars = new char[this.n];
    Arrays.fill(chars, '.');
    // 计算以2为底bit的对数
    int index = (int) (Math.log(bit) / Math.log(2));
    chars[index] = 'Q';
    String str = new String(chars);
    return str;
  }

  public static void main(String[] args) {
    LeetCode51 leetcode51 = new LeetCode51();
    List<List<String>> ans = leetcode51.resolveNQueen(4);
    for (List<String> list : ans) {
      System.out.println("[");
      for (String str : list) {
        System.out.println(str);
      }
      System.out.println("]");
    }
  }
}
