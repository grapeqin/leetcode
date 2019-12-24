package github.grapeqin.dynamicprogramming;

/**
 * Fibonacci的几种解法
 *
 * @description
 * @author qinzy
 * @date 2019-12-16
 */
public class FibonaccoTest {

  /**
   * 1.递归模式 时间复杂度为2的n次方
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

  /**
   * 求矩阵的n-1次幂
   *
   * <p>时间复杂度为logN
   *
   * @param n
   * @return
   */
  public int fibonacci5(int n) {
    if (n < 2) {
      return n;
    }
    int[][] matrix = new int[][] {{1, 1}, {1, 0}};
    recurse(matrix, n - 1);
    return matrix[0][0];
  }

  /**
   * 递归求X的N次幂
   *
   * <p>参考链接：
   * https://leetcode-cn.com/problems/fibonacci-number/solution/fei-bo-na-qi-shu-by-leetcode/
   *
   * @param matrix
   * @param n
   */
  private void recurse(int[][] matrix, int n) {
    if (n < 2) {
      return;
    }
    recurse(matrix, n / 2);
    multiply(matrix, matrix);

    int[][] a = new int[][] {{1, 1}, {1, 0}};
    // 基数
    if ((n & 1) == 1) {
      multiply(matrix, a);
    }
  }

  /**
   * 矩阵求和
   *
   * @param a
   * @param b
   */
  private void multiply(int[][] a, int[][] b) {
    int x = a[0][0] * b[0][0] + a[0][1] * b[1][0];
    int y = a[0][0] * b[0][1] + a[0][1] * b[1][1];
    int z = a[1][0] * b[0][0] + a[1][1] * b[1][0];
    int w = a[1][0] * b[0][1] + a[1][1] * b[1][1];

    a[0][0] = x;
    a[0][1] = y;
    a[1][0] = z;
    a[1][1] = w;
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
    System.out.println(test.fibonacci5(n) == test.fibonacci3(n));
  }
}
