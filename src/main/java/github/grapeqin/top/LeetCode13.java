package github.grapeqin.top;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @description
 * @author qinzy
 * @date 2020-01-02
 */
public class LeetCode13 {

  private Map<String, Integer> map = new HashMap<>();

  {
    // 初始化罗马数字与整数的对应关系
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    map.put("IV", 4);
    map.put("IX", 9);
    map.put("XL", 40);
    map.put("XC", 90);
    map.put("CD", 400);
    map.put("CM", 900);
  }

  public int romanToInt(String s) {
    if (null == s || s.length() < 1) {
      return 0;
    }
    int ans = 0;
    for (int i = 0; i < s.length(); ) {
      // 优先判断是否还有2位罗马数字
      if (i + 2 <= s.length() && map.containsKey(s.substring(i, i + 2))) {
        ans += map.get(s.substring(i, i + 2));
        i += 2;
      } else {
        ans += map.get(s.substring(i, i + 1));
        i++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    LeetCode13 leetCode13 = new LeetCode13();
    String s = "IXLVIII";
    System.out.println(leetCode13.romanToInt(s));
  }
}
