package byx.leetcode.problem.删除排序链表中的重复元素II;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode p = front;

        while (p != null && p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                ListNode q = p.next.next;
                while (q != null && q.val == p.next.val) {
                    q = q.next;
                }
                p.next = q;
            } else {
                p = p.next;
            }
        }

        return front.next;
    }
}
