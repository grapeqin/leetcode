package github.grapeqin.linkedlist;

/**
 * 判断单链表是否循环链表
 * 快慢指针:
 * 1、慢指针每次走一步
 * 2、快指针每次走两步
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode h = head;
        if (h == null || h.next == null) {
            return false;
        }
        ListNode n = h.next.next;
        while (h != null && n != null) {
            if (h == n) {
                return true;
            }
            h = h.next;
            if(n.next == null){
                return false;
            }
            n = n.next.next;
        }
        return false;
    }
}
