package github.grapeqin.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索II 需要引用 LeetCode209中定义的Trie结构
 *
 * @description
 * @author qinzy
 * @date 2019-12-12
 */
public class LeetCode212 {

  private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private Trie trie;

  private char[][] board;

  public List<String> findWords(char[][] board, String[] words) {
    List<String> ans = new ArrayList<>();
    trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    this.board = board;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(ans, "", i, j);
      }
    }
    return ans;
  }

  /**
   * 回溯求解 判断从坐标(row,col)开始的位置是否存在字符串位于trie结构中
   *
   * @param ans
   * @param cur
   * @param row
   * @param col
   * @return
   */
  private void dfs(List<String> ans, String cur, int row, int col) {
    char c = board[row][col];
    cur += c;

    if (trie.search(cur) && !ans.contains(cur)) {
      ans.add(cur);
    }
    // 剪枝
    if (!trie.startsWith(cur)) {
      return;
    }

    board[row][col] = '+';
    for (int k = 0; k < 4; k++) {
      int x = row + direction[k][0];
      int y = col + direction[k][1];
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '+') {
        dfs(ans, cur, x, y);
      }
    }
    board[row][col] = c;
  }

  public static void main(String[] args) {
    LeetCode212 leetCode212 = new LeetCode212();
    char[][] board =
        new char[][] {
          {'o', 'a', 'a', 'n'},
          {'e', 't', 'a', 'e'},
          {'i', 'h', 'k', 'r'},
          {'i', 'f', 'l', 'v'}
        };
    String[] words = new String[] {"oath", "pea", "eat", "rain"};
    List<String> ans = leetCode212.findWords(board, words);
    ans.stream().forEach((x) -> System.out.println(x));
  }
}
