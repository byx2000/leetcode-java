package byx.leetcode.longest_valid_parentheses;

// https://leetcode.cn/problems/longest-valid-parentheses/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // 剪枝
            if (s.charAt(i) == ')' || s.length() - i <= maxLen) {
                continue;
            }

            // 求s[i]开头的最长有效括号串
            int cnt = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    cnt++;
                } else {
                    if (cnt == 0) {
                        break;
                    } else {
                        cnt--;
                    }
                }
                if (cnt == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.longestValidParentheses("(()"));
        assertEquals(4, s.longestValidParentheses(")()())"));
        assertEquals(0, s.longestValidParentheses(""));
    }
}
