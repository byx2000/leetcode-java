package byx.leetcode.longest_substring_with_at_least_k_repeating_characters;

// https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                if (valid(cnt, k)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean valid(int[] cnt, int k) {
        for (int c : cnt) {
            if (c > 0 && c < k) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.longestSubstring("aaabb", 3));
        assertEquals(5, s.longestSubstring("ababbc", 2));
    }
}
