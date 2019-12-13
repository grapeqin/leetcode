package github.grapeqin.trie;

/**
 * 单词搜索
 *
 * @description
 * @author qinzy
 * @date 2019-12-12
 */
public class LeetCode79 {

  private static final char PLACEHOLDER = '+';

  private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, word, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 深度优先搜索
   *
   * @param row 横坐标
   * @param col 纵坐标
   * @param index 字符串的每个字符下标
   * @return
   */
  private boolean dfs(char[][] board, String word, int row, int col, int index) {
    // 判断到最后一个字符
    if (index == word.length() - 1) {
      // 返回的结果取决于最后一个字符是否相等
      return board[row][col] == word.charAt(index);
    }
    if (word.charAt(index) == board[row][col]) {
      // 保护现场
      char c = board[row][col];
      // 记录已经走过的网格
      board[row][col] = PLACEHOLDER;
      for (int k = 0; k < direction.length; k++) {
        // 当前单元格上下左右进行询问
        int x = row + direction[k][0];
        int y = col + direction[k][1];
        if (validate(board, x, y)) {
          if (dfs(board, word, x, y, index + 1)) {
            return true;
          }
        }
      }
      // 恢复现场
      board[row][col] = c;
    }
    return false;
  }

  private boolean validate(char[][] board, int row, int col) {
    // 横坐标越界
    if (row < 0 || row >= board.length) {
      return false;
    }
    // 纵坐标越界
    if (col < 0 || col >= board[0].length) {
      return false;
    }
    // 当前单元格已经使用了
    if (board[row][col] == PLACEHOLDER) {
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
    board =
        new char[][] {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'}
        };
    word = "SEE";
    System.out.println(leetCode79.exist(board, word));
    board =
        new char[][] {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'}
        };
    word = "ABCB";
    System.out.println(leetCode79.exist(board, word));

    board = new char[][] {{'a'}};
    word = "a";
    System.out.println(leetCode79.exist(board, word));
  }
}
