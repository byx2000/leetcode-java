package byx.leetcode.problem.删除排序链表中的重复元素;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;

        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }

        return head;
    }
}
