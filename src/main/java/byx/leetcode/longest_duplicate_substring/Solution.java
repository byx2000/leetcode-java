package byx.leetcode.longest_duplicate_substring;

// https://leetcode.cn/problems/longest-duplicate-substring/

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public String longestDupSubstring(String s) {
        int left = 1, right = s.length() - 1;
        String result = "";

        while (left <= right) {
            int mid = (left + right) / 2;
            String sub = findLength(s, mid);
            if ("".equals(sub)) {
                right = mid - 1;
            } else {
                result = sub;
                left = mid + 1;
            }
        }

        return result;
    }

    // 查找并返回s中长度为len的并且重复出现的子串
    private String findLength(String s, int len) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i + len <= s.length(); i++) {
            String sub = s.substring(i, i + len);
            if (set.contains(sub)) {
                return sub;
            } else {
                set.add(sub);
            }
        }
        return "";
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("ana", s.longestDupSubstring("banana"));
        assertEquals("", s.longestDupSubstring("abcd"));
    }
}
