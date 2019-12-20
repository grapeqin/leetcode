package github.grapeqin.array;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @description
 * @author qinzy
 * @date 2019-12-20
 */
public class QuickSort {

  public void quickSort(int[] num) {
    if (null == num) {
      return;
    }
    quickSort(num, 0, num.length - 1);
  }

  /**
   * 递归三部曲 1、定义递归终止条件 2、运算递归条件 3、递归调用
   *
   * @param num
   * @param left
   * @param right
   */
  private void quickSort(int[] num, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = sort(num, left, right);
    quickSort(num, left, mid - 1);
    quickSort(num, mid + 1, right);
  }

  private int sort(int[] num, int left, int right) {
    int pivot = num[left];
    while (left < right) {
      while (left < right && num[right] >= pivot) {
        right--;
      }
      num[left] = num[right];
      while (left < right && num[left] <= pivot) {
        left++;
      }
      num[right] = num[left];
    }
    num[left] = pivot;
    return left;
  }

  public static void main(String[] args) {
    QuickSort qs = new QuickSort();
    int[] num = new int[] {5, 1, 1, 2, 0, 0};
    qs.quickSort(num);
    System.out.println("排序后的数组为: ");
    Arrays.stream(num).forEach((x) -> System.out.print(x + ","));
  }
}
