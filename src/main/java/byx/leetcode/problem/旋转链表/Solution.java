package byx.leetcode.problem.旋转链表;

import byx.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 计算链表长度
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        k = k % len;

        if (k == 0) {
            return head;
        }

        // 此时p指向链表最后一个节点
        // 将链表变成环
        p.next = head;

        // 在指定的位置将环拆开
        for (int i = 0; i < len - k - 1; ++i) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}
