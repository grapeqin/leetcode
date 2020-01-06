package github.grapeqin.top;

/**
 * 删除链表的倒数第N个节点
 *
 * @description
 * @author qinzy
 * @date 2020-01-06
 */
public class LeetCode19 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode left = dummy, right = dummy;
    for (int i = 0; i < n; i++) {
      right = right.next;
    }
    while (right.next != null) {
      left = left.next;
      right = right.next;
    }
    if (left.next != null) {
      left.next = left.next.next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    LeetCode19 leetCode19 = new LeetCode19();
    ListNode head = new ListNode(1), cur = head;
    cur.next = new ListNode(2);
    cur = cur.next;
    cur.next = new ListNode(3);
    cur = cur.next;
    cur.next = new ListNode(4);
    cur = cur.next;
    cur.next = new ListNode(5);
    ListNode ans = leetCode19.removeNthFromEnd(head, 2);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }
}
