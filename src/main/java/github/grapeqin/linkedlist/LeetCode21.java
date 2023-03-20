package github.grapeqin.linkedlist;

/**
 * 合并2个有序链表
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null){
            ListNode node = null;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            cur.next = node;
            cur = cur.next;
        }

        ListNode last = l1 == null ? l2 : l1;

        while (last != null){
            cur.next = last;
            cur = cur.next;
            last = last.next;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
