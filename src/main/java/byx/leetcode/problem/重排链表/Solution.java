package byx.leetcode.problem.重排链表;

import byx.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class Solution {
    public void reorderList(ListNode head) {
        List<Integer> nums = toList(head);
        int i = 0, j = nums.size() - 1;

        while (i < j) {
            head.val = nums.get(i);
            i++;
            head = head.next;

            head.val = nums.get(j);
            j--;
            head = head.next;
        }

        if (i == j) {
            head.val = nums.get(i);
        }
    }

    private List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }
}
