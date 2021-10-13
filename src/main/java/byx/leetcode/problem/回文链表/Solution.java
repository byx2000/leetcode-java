package byx.leetcode.problem.回文链表;

import byx.leetcode.common.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode n) {
        // 计算链表长度
        int len = 0;
        ListNode p = n;
        while (p != null) {
            len++;
            p = p.next;
        }

        // 找到链表中间节点
        ListNode mid = n;
        for (int i = 0; i < len / 2; ++i) {
            mid = mid.next;
        }
        if (len % 2 == 1) {
            mid = mid.next;
        }

        // 反转后半段链表
        mid = reverse(mid);

        // 比较前半段与后半段是否相等
        p = n;
        while (mid != null) {
            if (p.val != mid.val) {
                return false;
            }
            p = p.next;
            mid = mid.next;
        }

        return true;
    }

    private ListNode reverse(ListNode n) {
        if (n == null || n.next == null) {
            return n;
        }

        ListNode t1 = n.next;
        ListNode t2 = reverse(n.next);
        t1.next = n;
        n.next = null;
        return t2;
    }
}
