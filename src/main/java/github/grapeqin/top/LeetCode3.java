package github.grapeqin.top;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @description
 * @author qinzy
 * @date 2019-12-26
 */
public class LeetCode3 {
  /**
   * 思路1
   *
   * <p>使用两重循环依次迭代所有的子串,判断最后一个字符是否存在于前面的子串中,不存在计数器+1
   *
   * <p>时间复杂度N的三次方
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring1(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    int ans = 1;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (!containsChar(s, i, j)) {
          ans = Math.max(ans, j - i + 1);
        } else {
          break;
        }
      }
    }
    return ans;
  }

  /**
   * 字符串s中第j个元素在[i,j)的子串中是否存在
   *
   * @param s
   * @param i
   * @param j
   * @return
   */
  private boolean containsChar(String s, int i, int j) {
    for (int k = i; k < j; k++) {
      if (s.charAt(k) == s.charAt(j)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 思路2
   *
   * <p>1、判断元素在子串中是否存在，引入set数据结构，这样判断元素是否存在的时间复杂度从O(N)降为O(1) 2、两层循环遍历子串 引入 滑动窗口的概念i,j 将两重循环降为一重循环
   *
   * <p>窗口指针i,j最终都要从0开始一直挪动到字符串的末尾 时间复杂度为 O(2N) 即 O(N)
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring2(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    int ans = 1;
    Set<Character> set = new HashSet<>();
    int length = s.length();
    for (int i = 0, j = 0; j < length; ) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }

  /**
   * 思路3
   *
   * <p>在思路2中,当发现j位置的元素已经存在与[i,j)所代表的子串中，说明在子串中存在一个字符与j位置的元素相等，假设该位置为j1，为了提高遍历性能
   * 可以直接让i挪动到j1+1，为存储元素的位置可以引入Map结构，既能当set使用，也能存储每个字符的index，加速i的滑动
   *
   * <p>由于只有j会从0走完字符串，所以相比较思路2，性能更优 时间复杂度为O(N)
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring3(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    int ans = 1, n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) {
        // 将滑动窗口左界挪到子串相同字符的下一位
        i = Math.max(i, map.get(s.charAt(j)) + 1);
      }
      // 每一步都要put，可以将右界相同字符的index放到map中
      map.put(s.charAt(j), j);
      ans = Math.max(ans, j - i + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode3 leetCode3 = new LeetCode3();
    String s = "abcabcbb";
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring2(s));

    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring3(s));

    s = "abba";
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring2(s));
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring3(s));

    s = null;
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring2(s));
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring3(s));

    s = "";
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring2(s));
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring3(s));

    s = "pwwkew";
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring2(s));
    System.out.println(
        leetCode3.lengthOfLongestSubstring1(s) == leetCode3.lengthOfLongestSubstring3(s));
  }
}
