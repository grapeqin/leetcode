package github.grapeqin.dynamicprogramming;

/**
 * 爬楼梯
 *
 * @description
 * @author qinzy
 * @date 2019-12-17
 */
public class LeetCode70 {
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int f_last_two_steps = 1;
    int f_last_one_steps = 2;
    int steps = 0;
    for (int i = 2; i < n; i++) {
      steps = f_last_two_steps + f_last_one_steps;
      f_last_two_steps = f_last_one_steps;
      f_last_one_steps = steps;
    }
    return steps;
  }

  public static void main(String[] args){
    LeetCode70 leetCode70 = new LeetCode70();
    System.out.println(leetCode70.climbStairs(4) == 5);
  }
}
