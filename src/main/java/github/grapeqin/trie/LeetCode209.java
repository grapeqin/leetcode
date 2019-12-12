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

  private TrieNode root;

  /** 结点声明 */
  private static final class TrieNode {
    private char val;
    private boolean isWord;
    private TrieNode[] children = new TrieNode[26];

    private TrieNode() {}

    private TrieNode(char val) {
      this.val = val;
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
      if (tn.children[c - 'a'] == null) {
        tn.children[c - 'a'] = new TrieNode(c);
      }
      tn = tn.children[c - 'a'];
    }
    tn.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode tn = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (tn.children[c - 'a'] == null) {
        return false;
      }
      tn = tn.children[c - 'a'];
    }
    return tn.isWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode tn = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (tn.children[c - 'a'] == null) {
        return false;
      }
      tn = tn.children[c - 'a'];
    }
    return true;
  }
}
