package byx.leetcode.get_equal_substrings_within_budget;

// https://leetcode.cn/problems/get-equal-substrings-within-budget/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int j = 0;
        int cost = 0;
        int maxLen = 0;

        while (j < s.length()) {
            while (j < s.length() && cost <= maxCost) {
                maxLen = Math.max(maxLen, j - i);
                cost += Math.abs(s.charAt(j) - t.charAt(j));
                j++;
            }

            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
        }

        maxLen = Math.max(maxLen, j - i);

        return maxLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.equalSubstring("abcd", "bcdf", 3));
        assertEquals(1, s.equalSubstring("abcd", "cdef", 3));
        assertEquals(1, s.equalSubstring("abcd", "acde", 0));
    }
}
