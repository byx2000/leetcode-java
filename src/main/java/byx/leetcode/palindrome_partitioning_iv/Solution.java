package byx.leetcode.palindrome_partitioning_iv;

// https://leetcode.cn/problems/palindrome-partitioning-iv/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    private Boolean[][] cache;

    public boolean checkPartitioning(String s) {
        this.cache = new Boolean[s.length()][s.length()];

        // 将s分割成[0, i)、[i, j)和[j, len)三段
        for (int i = 1; i < s.length(); i++) {
            if (!isPalindrome(s, 0, i - 1)) {
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (!isPalindrome(s, i, j - 1)) {
                    continue;
                }
                if (isPalindrome(s, j, s.length() - 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == j) {
            return cache[i][j] = true;
        }

        if (i + 1 == j) {
            return cache[i][j] = s.charAt(i) == s.charAt(j);
        }

        return cache[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkPartitioning("abcbdd"));
        assertFalse(s.checkPartitioning("bcbddxy"));
        assertTrue(s.checkPartitioning("bbab"));
    }
}
