package github.grapeqin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后问题
 *
 * @description
 * @author qinzy
 * @date 2019-12-10
 */
public class LeetCode51 {

  public List<List<String>> resolveNQueen(int n) {
    List<int[]> queen = new ArrayList<>();
    // 存放一个解决方案的临时数组
    int[] ans = new int[n];
    // 存放本次迭代中已被占用的列下标的集合
    Set<Integer> cols = new HashSet<>();
    // 存放本次迭代中斜线之和的集合
    Set<Integer> pie = new HashSet<>();
    // 存放本次迭代中反斜线之差的集合
    Set<Integer> na = new HashSet<>();

    resolve(0, ans, cols, pie, na, queen);
    printQueen(queen);
    return convertArrayToList(queen);
  }

  private List<List<String>> convertArrayToList(List<int[]> queen) {
    List<List<String>> ans = new ArrayList<>(queen.size());
    for (int[] array : queen) {
      List<String> line = new ArrayList<>();
      for (int i = 0; i < array.length; i++) {
        char[] chars = new char[array.length];
        Arrays.fill(chars, '.');
        chars[array[i]] = 'Q';
        line.add(new String(chars));
      }
      ans.add(line);
    }
    return ans;
  }

  private void printQueen(List<int[]> queen) {
    for (int[] array : queen) {
      System.out.println("[");
      for (int i = 0; i < array.length; i++) {
        printStr(array[i], array.length);
      }
      System.out.println("]");
    }
  }

  private void printStr(int j, int n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i != j) {
        builder.append(".");
      } else {
        builder.append("Q");
      }
    }
    System.out.println(builder.toString());
  }

  /**
   * @param row 第row行
   * @param ans 存放每个方案的i,j i为下标，j为int[i]的值
   * @param cols 存放当前方案中已经被占用的列集合
   * @param pie 存放当前方案中已经被占用的斜线集合
   * @param na 存放当前方案中已经被占用的反斜线结合
   * @param queen 存放完整解决方案的集合
   */
  private void resolve(int row, int[] ans, Set cols, Set pie, Set na, List<int[]> queen) {
    for (int col = 0; col < ans.length; col++) {
      // 不符合N皇后的规则定义直接试验下一个位置
      if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
        continue;
      }
      // 保存结果
      ans[row] = col;
      // 限制条件保存
      cols.add(col);
      pie.add(row + col);
      na.add(row - col);

      if (row + 1 == ans.length) {
        // 注意这里一定要保存ans的克隆对象,数组对象有引用，会对结果产生干扰
        queen.add(ans.clone());
      } else {
        resolve(row + 1, ans, cols, pie, na, queen);
      }
      // 如果没有找到结果，说明前面这次结果不算数，要重新计算
      cols.remove(col);
      pie.remove(row + col);
      na.remove(row - col);
    }
  }

  public static void main(String[] args) {
    LeetCode51 myNQueen = new LeetCode51();
    List<List<String>> ans = myNQueen.resolveNQueen(4);
    for (List<String> list : ans) {
      System.out.println("----------");
      for (String str : list) {
        System.out.println(str);
      }
    }
  }
}
