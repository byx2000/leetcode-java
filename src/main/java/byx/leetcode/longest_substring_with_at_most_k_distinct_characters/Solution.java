package byx.leetcode.longest_substring_with_at_most_k_distinct_characters;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
// https://www.lintcode.com/problem/386/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> chs = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < s.length()) {
            while (j < s.length() && valid(chs, k)) {
                maxLen = Math.max(maxLen, j - i);
                chs.put(s.charAt(j), chs.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }

            while (!valid(chs, k)) {
                chs.put(s.charAt(i), chs.get(s.charAt(i)) - 1);
                i++;
            }
        }

        maxLen = Math.max(maxLen, j - i);

        return maxLen;
    }

    private boolean valid(Map<Character, Integer> chs, int k) {
        return chs.values().stream().filter(v -> v > 0).count() <= k;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.lengthOfLongestSubstringKDistinct("eceba", 3));
        assertEquals(4, s.lengthOfLongestSubstringKDistinct("WORLD", 4));
    }
}
