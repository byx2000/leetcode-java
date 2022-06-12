package byx.leetcode.minimum_add_to_make_parentheses_valid;

// https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        return left + right;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.minAddToMakeValid("())"));
        assertEquals(3, s.minAddToMakeValid("((("));
    }
}
