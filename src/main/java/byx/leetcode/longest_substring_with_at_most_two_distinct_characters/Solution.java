package byx.leetcode.longest_substring_with_at_most_two_distinct_characters;

// https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/
// https://www.lintcode.com/problem/928

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> chs = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < s.length()) {
            while (j < s.length() && valid(chs)) {
                maxLen = Math.max(maxLen, j - i);
                chs.put(s.charAt(j), chs.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }

            while (!valid(chs)) {
                chs.put(s.charAt(i), chs.get(s.charAt(i)) - 1);
                i++;
            }
        }

        maxLen = Math.max(maxLen, j - i);

        return maxLen;
    }

    private boolean valid(Map<Character, Integer> chs) {
        return chs.values().stream().filter(v -> v > 0).count() <= 2;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstringTwoDistinct("eceba"));
        assertEquals(3, s.lengthOfLongestSubstringTwoDistinct("aaa"));
    }
}
