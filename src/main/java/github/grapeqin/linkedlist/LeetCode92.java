package github.grapeqin.linkedlist;

/**
 * 链表反转(部分结点)
 * 1、遍历链表,遍历过程中将链表分成3段
 * 第一段:反转链表前面那部分,用pre指针表示最后一个节点
 * 第二段:反转链表部分,leftNode表示第一个节点,rightNode表示最后一个节点
 * 第三段:反转链表尾部那部分,用cur表示第一个节点
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        //链表的开头
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        //链表的结尾
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode cur = rightNode.next;
        //断开链表
        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;
    }

    private void reverse(ListNode head){
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while(cur != null){
            ListNode node = cur;
            cur = cur.next;

            node.next = dummy.next;
            dummy.next = node;
        }
        head = dummy.next;
    }
}
