package github.grapeqin;

/**
 * 寻找两个有序数组的中位数
 *
 * <p>一、中位数概念
 *
 * <p>对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。 如果观察值有偶数个，通常取最中间的两个数值的平均数作为中位数
 *
 * <p>思路1:
 *
 * <p>暴力法:用两重循环将2个有序数组合并成1个，然后在根据数组的长度是奇数还是偶数来得到中位数 但这样子时间复杂度为N的平方，不符合题意
 *
 * <p>思路2:
 *
 * <p>假设两个数组分别为A、B,长度分别为m和n,将数组A分割为2个子数组有m+1种分法,即i=0~m-1
 * i=0表示leftA子数组为空,i=m-1表示rightA子数组为空,为了保证切分的在正中间,切分后 length(leftA) = length(rightA) 即 i = m - i
 * 同理,对数组B切分也可以得到 length(leftB) = length(rightB) 即 j = m - j
 *
 * <p>我们将leftA、leftB 合并成 leftPart数组,rightA、rightB合并成 rightPart数组
 *
 * <p>当m+n为偶数时,那么 i+j = m-i+n-j 则 j = (m+n)/2-i 当m+n为奇数时,那么 i+j = m-i+n-j+1 则 j = (m+n+1)/2-i
 * 为了简化计算公式,当m+n为偶数时,我们同样令 j = (m+n+1)/2-i 不影响最终的运算结果 这样 j = (m+n+1)/2 - i 就统一了
 *
 * <p>由于j为B数组的下标 j>=0 && j<=n-1 那么 (m+n+1)/2 - i <= n-1 推导出 m <= n
 *
 * <p>现在已经将A、B两个数组左右两边分为相等的2个子数组了,开始找中位数
 *
 * <p>需要保证 max(A[i-1],B[j-1]) <= min(A[i],B[j]) 由于A、B都是有序数组 自然 A[i-1] <= A[i] B[j-1] <= B[j] 我们只需要确保
 * A[i-1] <= B[j] && B[j-1] <= A[i]
 *
 * @description
 * @author qinzy
 * @date 2019-12-26
 */
public class LeetCode4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    if (m > n) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int iMin = 0;
    int iMax = m;
    while (iMin <= iMax) {
      int i = (iMin + iMax) >> 1;
      // 根据中位数的定义推导出来的公式
      int j = (m + n + 1) / 2 - i;
      if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
        iMax = i - 1;
      } else if (i != m && j != 0 && nums2[j - 1] > nums1[i]) {
        iMin = i + 1;
      } else {
        int maxLeft;
        if (i == 0) {
          maxLeft = nums2[j - 1];
        } else if (j == 0) {
          maxLeft = nums1[i - 1];
        } else {
          maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if ((m + n & 1) == 1) {
          return maxLeft;
        }
        int minRight;
        if (i == m) {
          minRight = nums2[j];
        } else if (j == n) {
          minRight = nums1[i];
        } else {
          minRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

  public static void main(String[] args) {
    LeetCode4 leetCode4 = new LeetCode4();
    int[] nums1 = new int[] {1, 3};
    int[] nums2 = new int[] {2};
    System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));

    nums1 = new int[] {1, 2};
    nums2 = new int[] {3, 4};
    System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));
  }
}
