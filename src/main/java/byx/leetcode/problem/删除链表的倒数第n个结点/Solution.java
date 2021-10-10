package byx.leetcode.problem.删除链表的倒数第n个结点;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/SLwz0R/
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode p, int n) {
        ListNode head = new ListNode(0, p);

        ListNode p1 = p;
        for (int i = 0; i < n; ++i) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return head.next;
    }
}
