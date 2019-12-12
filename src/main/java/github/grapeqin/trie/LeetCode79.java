package github.grapeqin.trie;

/**
 * 单词搜索
 *
 * @description
 * @author qinzy
 * @date 2019-12-12
 */
public class LeetCode79 {

  private int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  public boolean exist(char[][] board, String word) {
    boolean[][] exist = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, exist, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 深度优先搜索
   *
   * @param board 原网格
   * @param exist 判断网格单元是否被占用
   * @param row 横坐标
   * @param col 纵坐标
   * @param word 目标单词
   * @param start 判断起点
   * @return
   */
  private boolean dfs(char[][] board, boolean[][] exist, int row, int col, String word, int start) {
    if (start == word.length() - 1) {
      return board[row][col] == word.charAt(start);
    }
    if (word.charAt(start) == board[row][col]) {
      exist[row][col] = true;
      for (int k = 0; k < 4; k++) {
        int x = row + direction[k][0];
        int y = col + direction[k][1];
        if (validate(x, y, board, exist)) {
          if (dfs(board, exist, x, y, word, start + 1)) {
            return true;
          }
        }
      }
      exist[row][col] = false;
    }
    return false;
  }

  private boolean validate(int row, int col, char[][] board, boolean[][] exist) {
    // 横坐标越界
    if (row < 0 || row >= board.length) {
      return false;
    }
    // 纵坐标越界
    if (col < 0 || col >= board[0].length) {
      return false;
    }
    // 当前单元格已经使用了
    if (exist[row][col]) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    LeetCode79 leetCode79 = new LeetCode79();
    char[][] board =
        new char[][] {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'}
        };
    String word = "ABCCED";
    System.out.println(leetCode79.exist(board, word));
    word = "SEE";
    System.out.println(leetCode79.exist(board, word));
    word = "ABCB";
    System.out.println(leetCode79.exist(board, word));

    board = new char[][] {{'a'}};
    word = "a";
    System.out.println(leetCode79.exist(board, word));
  }
}
