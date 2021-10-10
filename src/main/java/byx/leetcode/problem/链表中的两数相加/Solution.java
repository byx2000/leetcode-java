package byx.leetcode.problem.链表中的两数相加;

import byx.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lMSNwu/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode p1, ListNode p2) {
        List<Integer> n1 = toList(p1);
        List<Integer> n2 = toList(p2);
        List<Integer> r = new ArrayList<>();

        int i = 0, j = 0;
        int carry = 0;

        while (i < n1.size() && j < n2.size()) {
            int sum = n1.get(i) + n2.get(j) + carry;
            r.add(sum % 10);
            carry = sum / 10;
            i++;
            j++;
        }

        while (i < n1.size()) {
            int sum = n1.get(i) + carry;
            r.add(sum % 10);
            carry = sum / 10;
            i++;
        }

        while (j < n2.size()) {
            int sum = n2.get(j) + carry;
            r.add(sum % 10);
            carry = sum / 10;
            j++;
        }

        if (carry > 0) {
            r.add(carry);
        }

        Collections.reverse(r);

        return toListNode(r);
    }

    private List<Integer> toList(ListNode p) {
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        Collections.reverse(list);
        return list;
    }

    private ListNode toListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int n : list) {
            p.next = new ListNode(n);
            p = p.next;
        }
        return head.next;
    }
}
