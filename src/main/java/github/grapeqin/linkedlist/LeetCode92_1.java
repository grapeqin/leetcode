package github.grapeqin.linkedlist;

/**
 * 链表反转(部分结点)<br/>
 * 遍历链表,找到待反转链表部分,反转[left+1,right]部分的节点<br/>
 * 第一步:从链表头开始遍历,用pre指针指向left-1位置的节点,curr指向left位置的节点<br/>
 * 第二步:定义nxt = curr.next,然后将nxt位置的节点插到pre和curr指针之间的位置<br/>
 * curr.next = nxt.next<br/>
 * nxt.next = pre.next<br/>
 * pre.next = nxt<br/>
 * 第三步:第二步遍历到nxt == right位置的节点为止,停止循环
 */
public class LeetCode92_1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        ListNode nxt;
        for(int i = 0;i < right - left;i++){
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = pre.next;
            pre.next = nxt;
        }
        return dummy.next;
    }
}
