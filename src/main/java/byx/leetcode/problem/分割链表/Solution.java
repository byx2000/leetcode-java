package byx.leetcode.problem.分割链表;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode q = head;

        while (q != null) {
            if (q.val >= x) {
                q = q.next;
            } else {
                swap(p, q);
                p = p.next;
                q = q.next;
            }
        }

        return head;
    }

    private void swap(ListNode p, ListNode q) {
        int t = p.val;
        p.val = q.val;
        q.val = t;
    }
}
