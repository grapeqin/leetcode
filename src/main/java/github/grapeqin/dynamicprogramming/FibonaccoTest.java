package github.grapeqin.dynamicprogramming;

/**
 * @description
 * @author qinzy
 * @date 2019-12-16
 */
public class FibonaccoTest {

  /**
   * 递归模式
   *
   * @param n
   * @return
   */
  public int fibonacci(int n) {
    if (n < 2) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  /**
   * 递归+缓存模式
   *
   * @param n
   * @return
   */
  public int fibonacci2(int n) {
    if (n < 2) {
      return n;
    }
    int[] array = new int[n + 1];
    array[0] = 0;
    array[1] = 1;
    return fibonacc(n, array);
  }

  private int fibonacc(int n, int[] array) {
    if (n < 2) {
      return n;
    }
    if (array[n] == 0) {
      array[n] = fibonacc(n - 1, array) + fibonacc(n - 2, array);
    }
    return array[n];
  }

  /**
   * 递推方式，空间复杂度O(N)
   *
   * @param n
   * @return
   */
  public int fibonacci3(int n) {
    if (n < 2) {
      return n;
    }
    int[] array = new int[n + 1];
    array[0] = 0;
    array[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      array[i] = array[i - 1] + array[i - 2];
    }
    return array[n];
  }

  /**
   * 递推方式，空间复杂度O(1)
   *
   * @param n
   * @return
   */
  public int fibonacci4(int n) {
    if (n < 2) {
      return n;
    }
    int a = 0;
    int b = 1;
    int c = a + b;
    for (int i = 2; i < n + 1; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }

  public static void main(String[] args) {
    FibonaccoTest test = new FibonaccoTest();
    int n = 40;
    validFibonacci(n, test);
    n = 0;
    validFibonacci(n, test);
  }

  private static void validFibonacci(int n, FibonaccoTest test) {
    System.out.println(test.fibonacci4(n) == test.fibonacci(n));
    System.out.println(test.fibonacci4(n) == test.fibonacci2(n));
    System.out.println(test.fibonacci4(n) == test.fibonacci3(n));
  }
}
