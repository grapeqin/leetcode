package github.grapeqin.linkedlist;

/**
 * 环形链表II<br/>
 * 1.先通过快慢指针判断链表是否有环<br/>
 * 2.重置fast=head,然后fast和slow依次往后遍历,直到fast == slow即找到入环节点
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
