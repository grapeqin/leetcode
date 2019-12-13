package github.grapeqin.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索II
 *
 * <p>思路1 可以借助LeetCode79中的函数 针对列表中每个单词进行一次递归，这样子每个单词在棋盘上要递归一遍，效率比较差
 *
 * <p>思路2 将要匹配的单词列表构造成一棵Trie树，利用Trie树的search和startWith方法可以实现只遍历一次棋盘即可得到结果
 *
 * <p>需要引用 LeetCode209中定义的Trie结构
 *
 * @description
 * @author qinzy
 * @date 2019-12-12
 */
public class LeetCode212 {

  private static final char PLACEHOLDER = '+';

  private int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

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
    board[row][col] = PLACEHOLDER;
    for (int k = 0; k < direction.length; k++) {
      int x = row + direction[k][0];
      int y = col + direction[k][1];
      if (valid(x, y)) {
        dfs(ans, cur, x, y);
      }
    }
    board[row][col] = c;
  }

  /**
   * 验证坐标位置的合法性
   *
   * @param row
   * @param col
   * @return
   */
  private boolean valid(int row, int col) {
    if (row < 0 || row >= board.length) {
      return false;
    }
    if (col < 0 || col >= board[0].length) {
      return false;
    }
    if (board[row][col] == PLACEHOLDER) {
      return false;
    }
    return true;
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
