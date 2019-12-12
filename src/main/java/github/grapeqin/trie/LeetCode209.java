package github.grapeqin.trie;

/**
 * 实现一个Trie树结构
 *
 * @description
 * @author qinzy
 * @date 2019-12-12
 */
public class LeetCode209 {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println("trie.search(\"apple\")" + trie.search("apple"));
    System.out.println("trie.search(\"app\")" + trie.search("app"));
    System.out.println("trie.startsWith(\"app\")" + trie.startsWith("app"));
    trie.insert("app");
    System.out.println("trie.search(\"app\")" + trie.search("app"));
  }
}

class Trie {

  // 根结点
  private TrieNode root;

  /** 结点声明 */
  static final class TrieNode {
    // 值域
    private char val;

    // 是否健值的结尾
    private boolean end;

    // 存放孩子结点
    private TrieNode[] children = new TrieNode[26];

    private TrieNode() {}

    private TrieNode(char val) {
      this.val = val;
    }

    public boolean isEnd() {
      return end;
    }

    public void setEnd(boolean end) {
      this.end = end;
    }

    public char getVal() {
      return val;
    }

    public TrieNode getChild(char c) {
      return this.children[c - 'a'];
    }

    public void setChild(char c) {
      this.children[c - 'a'] = new TrieNode(c);
    }
  }

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode(' ');
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode tn = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (tn.getChild(c) == null) {
        tn.setChild(c);
      }
      tn = tn.getChild(c);
    }
    tn.setEnd(true);
  }

  /**
   * 检索指定的单词是否存在trie中
   *
   * @param word
   * @return
   */
  private TrieNode searchWord(String word) {
    TrieNode tn = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (tn.getChild(c) == null) {
        return null;
      }
      tn = tn.getChild(c);
    }
    return tn;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode tn = searchWord(word);
    return null == tn ? false : tn.isEnd();
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode tn = searchWord(prefix);
    return null != tn;
  }
}
