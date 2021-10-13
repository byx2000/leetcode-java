package byx.leetcode.problem.奇偶链表;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode p1 = h1;
        ListNode p2 = h2;

        while (true) {
            p1.next = p2.next;
            if (p1.next == null) {
                break;
            }
            p1 = p1.next;

            p2.next = p1.next;
            if (p2.next == null) {
                break;
            }
            p2 = p2.next;
        }

        p1.next = h2;

        return h1;
    }
}
