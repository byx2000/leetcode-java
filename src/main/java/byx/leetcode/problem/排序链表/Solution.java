package byx.leetcode.problem.排序链表;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = midPos(head);
        ListNode left = head, right = mid.next;
        mid.next = null;
        return merge(sortList(left), sortList(right));
    }

    // 找到链表的中点
    private ListNode midPos(ListNode head) {
        ListNode p = head, q = head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }

        if (h2 == null) {
            return h1;
        }

        if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }
}
