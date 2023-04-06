package github.grapeqin.linkedlist;

/**
 * 相交链表
 * 1、遍历两个链表，获取它们的长度以及尾节点。
 * 2、如果两个链表相交，则它们的尾节点一定相同。
 * 根据这个特点，我们可以将较长的链表向后移动两个链表长度的差值，使得两个链表的长度相等。
 * 然后同时遍历两个链表，直到找到它们的相交节点。
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = lengthOfListNode(headA);
        int n = lengthOfListNode(headB);
        ListNode a = headA;
        ListNode b = headB;
        if (m > n) {
            int gap = m - n;
            while (gap > 0) {
                a = a.next;
                gap--;
            }
        } else {
            int gap = n - m;
            while (gap > 0) {
                b = b.next;
                gap--;
            }
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private int lengthOfListNode(ListNode head) {
        int len = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            len++;
        }
        return len;
    }
}
