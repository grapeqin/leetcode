package github.grapeqin.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径之和
 *
 * @description
 * @author qinzy
 * @date 2019-12-17
 */
public class LeetCode120 {

  /**
   * 动态规划，从底往上找
   *
   * @param triangle
   * @return
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    // 存储DP状态的数组
    // triangle的行数
    int height = triangle.size();
    if (height == 0 || triangle.get(0).size() == 0) {
      return 0;
    }

    // triangle最后一行的list.size()
    int width = triangle.get(triangle.size() - 1).size();
    int[][] ans = new int[height][width];
    // 填充三角形最下面一行
    for (int i = 0; i < width; i++) {
      ans[height - 1][i] = triangle.get(height - 1).get(i);
    }
    // 从下往上找
    for (int i = height - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        ans[i][j] = triangle.get(i).get(j) + Math.min(ans[i + 1][j], ans[i + 1][j + 1]);
      }
    }
    return ans[0][0];
  }

  /**
   * 定义一维的存放DP状态的数据结构
   *
   * @param triangle
   * @return
   */
  public int minimumTotal2(List<List<Integer>> triangle) {
    // triangle的行数
    int height = triangle.size();
    if (height == 0 || triangle.get(0).size() == 0) {
      return 0;
    }
    // 用最后一行的数组来初始化结果数组
    List<Integer> ans = triangle.get(height - 1);
    // 从下往上找
    for (int i = height - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        ans.set(j, triangle.get(i).get(j) + Math.min(ans.get(j), ans.get(j + 1)));
      }
    }
    return ans.get(0);
  }

  public static void main(String[] args) {
    LeetCode120 leetCode120 = new LeetCode120();
    List<List<Integer>> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    cols.add(2);
    rows.add(cols);

    cols = new ArrayList<>();
    cols.add(3);
    cols.add(4);
    rows.add(cols);

    cols = new ArrayList<>();
    cols.add(6);
    cols.add(5);
    cols.add(7);
    rows.add(cols);

    cols = new ArrayList<>();
    cols.add(4);
    cols.add(1);
    cols.add(8);
    cols.add(3);
    rows.add(cols);

    int ans = leetCode120.minimumTotal(rows);
    System.out.println("miminumTotal is " + ans);
    ans = leetCode120.minimumTotal2(rows);
    System.out.println("miminumTotal2 is " + ans);
  }
}
