package github.grapeqin;

/**
 * 求解数独问题
 *
 * @description
 * @author qinzy
 * @date 2019-12-10
 */
public class LeetCode37 {

  public void solveSudoku(char[][] board) {
    solve(board);
  }

  /**
   * 求解数独问题
   *
   * @param board N*N的数组
   * @return
   */
  private boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char k = '1'; k <= '9'; k++) {
            // 如果指定位置可以放元素k
            if (isValid(board, i, j, k)) {
              board[i][j] = k;
              if (solve(board)) {
                return true;
              }
              board[i][j] = '.';
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 判断指定位置如果放字母c 是否符合数独的条件
   *
   * @param board
   * @param row
   * @param col
   * @param c
   * @return true 表示可以放入, false不能放入
   */
  private boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      // 行上面重复了
      if (board[row][i] != '.' && board[row][i] == c) {
        return false;
      }
      // 列上面重复了
      if (board[i][col] != '.' && board[i][col] == c) {
        return false;
      }
      // 3*3的小方块里面
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
          && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
        return false;
      }
    }
    return true;
  }
}
