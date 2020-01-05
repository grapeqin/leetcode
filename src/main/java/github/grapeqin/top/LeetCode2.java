package github.grapeqin.top;

/**
 * 两数相加
 *
 * @description
 * @author qinzy
 * @date 2019-12-24
 */
public class LeetCode2 {

  private static class ListNode {
    private int val;
    private ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0), cur = head, p1 = l1, p2 = l2;
    int sum = 0;
    while (null != p1 || null != p2 || sum > 0) {
      if (null != p1) {
        sum += p1.val;
        p1 = p1.next;
      }
      if (null != p2) {
        sum += p2.val;
        p2 = p2.next;
      }
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      sum /= 10;
    }
    return head.next;
  }
}
