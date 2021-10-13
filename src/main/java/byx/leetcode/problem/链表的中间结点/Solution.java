package byx.leetcode.problem.链表的中间结点;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
