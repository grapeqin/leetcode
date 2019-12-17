package github.grapeqin.dynamicprogramming;

/**
 * 在一个M*N的二维空间内，从起点(0,0)走到终点(M-1,N-1)的位置有多少种走法 只能往下+往右走
 *
 * @description
 * @author qinzy
 * @date 2019-12-17
 */
public class CountThePaths {

  /**
   * 递归解法
   *
   * @param board
   * @return
   */
  public int recursion(int[][] board) {
    return countPath(board, 0, 0);
  }

  private int countPath(int[][] board, int row, int col) {
    // 递归结束条件
    if (row == board.length - 1 && col == board[0].length - 1) {
      return 1;
    }
    // 非法条件判断
    if (row < 0 || row >= board.length) {
      return 0;
    }
    if (col < 0 || col >= board[0].length) {
      return 0;
    }
    if (board[row][col] == 0) {
      return countPath(board, row + 1, col) + countPath(board, row, col + 1);
    } else {
      return 0;
    }
  }

  /**
   * 递推解法
   *
   * @param board
   * @return
   */
  public int dp(int[][] board) {
    // 填充最后一行
    for (int j = 0; j < board[0].length; j++) {
      if (board[board.length - 1][j] == 0) {
        board[board.length - 1][j] = 1;
      }
    }
    // 填充最后一列
    for (int i = 0; i < board.length; i++) {
      if (board[i][board[0].length - 1] == 0) {
        board[i][board[0].length - 1] = 1;
      }
    }
    for (int i = board.length - 2; i >= 0; i--) {
      for (int j = board[0].length - 2; j >= 0; j--) {
        if (board[i][j] == 0) {
          board[i][j] = board[i + 1][j] + board[i][j + 1];
        } else {
          board[i][j] = 0;
        }
      }
    }
    return board[0][0];
  }

  public static void main(String[] args) {
    CountThePaths ctp = new CountThePaths();
    // board[i][j]=-1表示该位置为石头，不能通过
    int[][] board =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, -1, 0, 0, 0, -1, 0},
          {0, 0, 0, 0, -1, 0, 0, 0},
          {-1, 0, -1, 0, 0, -1, 0, 0},
          {0, 0, -1, 0, 0, 0, 0, 0},
          {0, 0, 0, -1, -1, 0, -1, 0},
          {0, -1, 0, 0, 0, -1, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0}
        };
    System.out.println("递归解法:" + ctp.recursion(board));
    System.out.println("递推解法:" + ctp.dp(board));
  }
}
