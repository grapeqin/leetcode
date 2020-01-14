package github.grapeqin.top;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @description
 * @author qinzy
 * @date 2020-01-13
 */
public class LeetCode20 {

  private Map<Character, Character> map;

  public LeetCode20() {
    this.map = new HashMap<>(3);
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
  }
  /**
   * 思路: 1、将括号分为左括号右括号,引入map存放右括号和左括号的对应关系
   * 2、迭代字符串s,对于每个字符,
   * 2.1、如果不是右括号,就当做左括号入栈,
   * 2.2、如果是右括号,栈顶元素出栈并且判断是否与当前元素匹配,不匹配直接返回false
   * 3、判断栈是否为空,为空则为有效括号,否则为无效括号
   *
   * 在2.2判断时有个特殊情况就是 如果当前元素为右括号并且栈是空的,表示栈中不存在对应的 左括号,
   * 可以直接返回false
   *
   * 时间复杂度O(N)
   * 空间复杂度O(N)
   *
   * @param s
   * @return
   */
  public boolean isValid(String s) {
    if (null == s || s.length() == 0) {
      return true;
    }
    Stack stack = new Stack();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      // 左括号
      if (!map.containsKey(s.charAt(i))) {
        stack.push(s.charAt(i));
      } else if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    LeetCode20 leetCode20 = new LeetCode20();
    String s = "()";
    System.out.println(leetCode20.isValid(s) == true);

    s = "()[]{}";
    System.out.println(leetCode20.isValid(s) == true);

    s = "()[]}";
    System.out.println(leetCode20.isValid(s) == false);

    s = "}";
    System.out.println(leetCode20.isValid(s) == false);
  }
}
