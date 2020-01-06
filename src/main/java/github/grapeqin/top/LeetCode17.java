package github.grapeqin.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @description
 * @author qinzy
 * @date 2020-01-06
 */
public class LeetCode17 {

  /**
   * 思路1: 依次遍历digits数组,对于每一个数字字符,遍历该数字字符对应的字母集合 如果ans结果集合字符数组长度与digits遍历的字符数相等,直接追加当前 字符
   *
   * @param digits
   * @return
   */
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<>();
    if (null == digits || digits.isEmpty()) {
      return ans;
    }
    ans.add("");
    // 准备映射集合
    Map<Character, String> map = initDigitToLetterMap();
    for (int i = 0; i < digits.length(); i++) {
      // 取队列中的中间结果,当其长度与当前迭代元素个数相等时
      while (ans.peek().length() == i) {
        // 取出当前中间结果
        String str = ans.remove();
        // 根据源串中数字取出字母映射结合,依次迭代
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
          // 将中间结果入队列
          ans.add(str + letters.charAt(j));
        }
      }
    }

    return ans;
  }

  private Map<Character, String> initDigitToLetterMap() {
    // 准备映射集合
    Map<Character, String> map = new HashMap<>(8);
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    return map;
  }

  /**
   * 思路2 递归
   *
   * @param digits
   * @return
   */
  public List<String> letterCombinations2(String digits) {
    Map<Character, String> map = initDigitToLetterMap();
    List<String> ans = new ArrayList<>();
    if (null == digits || digits.length() < 1) {
      return ans;
    }
    searchLetter("", digits, ans, map);
    return ans;
  }

  /**
   * 递归遍历所有字符
   *
   * @param str 临时存放结果的字符串
   * @param digits 剩余需要遍历的源字符串
   * @param ans 存放最终结果的字符串
   * @param map 存储数字到字母的映射关系
   */
  private void searchLetter(
      String str, String digits, List<String> ans, Map<Character, String> map) {
    // 递归终止条件
    if (digits.length() == 0) {
      ans.add(str);
      return;
    }
    String letters = map.get(digits.charAt(0));
    for (int i = 0; i < letters.length(); i++) {
      searchLetter(str + letters.charAt(i), digits.substring(1), ans, map);
    }
  }

  public static void main(String[] args) {
    LeetCode17 leetCode17 = new LeetCode17();
    String digits = "23";
    List<String> ans = leetCode17.letterCombinations(digits);
    ans.forEach(
        (x) -> {
          System.out.println(x);
        });

    ans = leetCode17.letterCombinations2(digits);
    ans.forEach(
        (x) -> {
          System.out.println(x);
        });
  }
}
