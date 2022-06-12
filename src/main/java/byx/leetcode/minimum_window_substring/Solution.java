package byx.leetcode.minimum_window_substring;

// https://leetcode.cn/problems/minimum-window-substring/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int begin = 0;
        int end = 0;
        Map<Character, Integer> m2 = new HashMap<>();

        while (j < s.length()) {
            while (j < s.length() && !cover(m1, m2)) {
                m2.put(s.charAt(j), m2.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }

            while (cover(m1, m2)) {
                if (j - i < minLen) {
                    minLen = j - i;
                    begin = i;
                    end = j;
                }
                m2.put(s.charAt(i), m2.get(s.charAt(i)) - 1);
                i++;
            }
        }

        return s.substring(begin, end);
    }

    // 判断m2是否完全覆盖m1
    private boolean cover(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Character c : m1.keySet()) {
            if (!m2.containsKey(c) || m1.get(c) > m2.get(c)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", s.minWindow("a", "a"));
        assertEquals("", s.minWindow("a", "aa"));
    }
}
