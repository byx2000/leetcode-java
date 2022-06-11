package byx.leetcode.longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < s.length()) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }

            maxLen = Math.max(maxLen, j - i);

            if (j == s.length()) {
                break;
            }

            while (s.charAt(i) != s.charAt(j)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.remove(s.charAt(i));
            i++;
        }

        return maxLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.lengthOfLongestSubstring(""));
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, s.lengthOfLongestSubstring("dvdf"));
    }
}
