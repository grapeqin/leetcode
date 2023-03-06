package github.grapeqin.linkedlist;

/**
 * 单链表反转
 */
public class LeetCode206 {

    /**
     * 借助于辅助节点,节点遍历及头插法组建新链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //创建伪头节点
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (null != cur) {
            ListNode node = cur;
            cur = cur.next;

            //以头插法构建新链表
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}
