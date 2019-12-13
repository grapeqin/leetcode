package github.grapeqin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后解法
 *
 * @description
 * @author qinzy
 * @date 2019-12-13
 */
public class LeetCode51NQueen {

  private int n;

  public List<List<String>> nQueen(int n) {
    this.n = n;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pies = new HashSet<>();
    Set<Integer> nas = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>(n);
    dfs(0, ans, list, cols, pies, nas);
    return ans;
  }

  /**
   * 逐行扫描
   *
   * @param row 行号
   * @param ans 保存最终结果的ans
   * @param list 保存每组结果的临时list
   * @param cols 保存已经被占用的cols
   * @param pies 保存已经被占用的斜线位置
   * @param nas 保存已经被占用的反斜线位置
   */
  private void dfs(
      int row,
      List<List<String>> ans,
      List<String> list,
      Set<Integer> cols,
      Set<Integer> pies,
      Set<Integer> nas) {
    for (int j = 0; j < this.n; j++) {
      // 先确定递归终止条件
      if (row == this.n) {
        // 小心结果的引用类型
        ans.add(new ArrayList<>(list));
        return;
      }
      // 剪枝
      if (cols.contains(j) || pies.contains(row + j) || nas.contains(row - j)) {
        continue;
      }

      String str = generateQueenString(j);
      list.add(str);
      cols.add(j);
      pies.add(row + j);
      nas.add(row - j);

      dfs(row + 1, ans, list, cols, pies, nas);

      list.remove(str);
      cols.remove(j);
      pies.remove(row + j);
      nas.remove(row - j);
    }
  }

  /**
   * 生成包含皇后位置的字符串
   *
   * @param j 皇后所在的位置
   * @return
   */
  private String generateQueenString(int j) {
    if (j < 0 || j >= n) {
      return null;
    }
    char[] chars = new char[n];
    Arrays.fill(chars, '.');
    chars[j] = 'Q';
    String str = new String(chars);
    return str;
  }

  public static void main(String[] args) {
    LeetCode51NQueen nQueen = new LeetCode51NQueen();
    System.out.println();
    List<List<String>> ans = nQueen.nQueen(5);
    for (List<String> list : ans) {
      System.out.println("[");
      for (String str : list) {
        System.out.println(str);
      }
      System.out.println("]");
    }
  }
}
