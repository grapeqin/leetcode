package github.grapeqin.ufs;

/**
 * 岛屿数量
 *
 * @description
 * @author qinzy
 * @date 2019-12-20
 */
public class LeetCode200 {
  int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int numIslands(char[][] grid) {
    if (null == grid || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    char[][] gd = grid.clone();
    for (int i = 0; i < gd.length; i++) {
      gd[i] = gd[i].clone();
    }
    int m = gd.length;
    int n = gd[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gd[i][j] == '1') {
          dfs(gd, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return;
    }
    if (grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    for (int ii = 0; ii < direction.length; ii++) {
      int newX = i + direction[ii][0];
      int newY = j + direction[ii][1];
      dfs(grid, newX, newY);
    }
  }

  public static void main(String[] args) {
    LeetCode200 leetCode200 = new LeetCode200();
    char[][] grid =
        new char[][] {
          {'1', '1', '0', '0', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '1', '0', '0'},
          {'0', '0', '0', '1', '1'}
        };
    System.out.println("岛屿数量为 : " + leetCode200.numIslands(grid));
  }
}
