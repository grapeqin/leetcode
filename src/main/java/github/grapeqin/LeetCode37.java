package github.grapeqin;

/**
 * 求解数独问题
 *
 * <p>空的位置用.填充
 *
 * @description
 * @author qinzy
 * @date 2019-12-13
 */
public class LeetCode37 {

  private static final char PLACEHOLDER = '.';

  public void solveSudoku(char[][] board) {
    dfs(board);
  }

  private boolean dfs(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == PLACEHOLDER) {
          for (char k = '1'; k <= '9'; k++) {
            if (valid(board, i, j, k)) {
              board[i][j] = k;
              if (dfs(board)) {
                return true;
              }
              board[i][j] = PLACEHOLDER;
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean valid(char[][] board, int row, int col, char k) {
    for (int i = 0; i < 9; i++) {
      // 同一列上是否有重复
      if (board[i][col] != PLACEHOLDER && board[i][col] == k) {
        return false;
      }
      // 同一行上是否有重复
      if (board[row][i] != PLACEHOLDER && board[row][i] == k) {
        return false;
      }
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != PLACEHOLDER
          && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k) {
        return false;
      }
    }
    return true;
  }
}
