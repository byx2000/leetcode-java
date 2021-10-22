package byx.leetcode.problem.最长重复子串;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-duplicate-substring/
 */
public class Solution {
    public String longestDupSubstring(String s) {
        int left = 1, right = s.length();
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String sub = check(s, mid);
            if ("".equals(sub)) {
                right = mid - 1;
            } else {
                result = sub;
                left = mid + 1;
            }
        }

        return result;
    }

    // 长度为len的重复子串
    private String check(String s, int len) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i + len - 1 < s.length(); ++i) {
            String sub = s.substring(i, i + len);
            if (set.contains(sub)) {
                return sub;
            } else {
                set.add(sub);
            }
        }
        return "";
    }
}
