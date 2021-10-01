package byx.leetcode.problem.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                maxLen = Math.max(maxLen, j - i);
                set.remove(s.charAt(i));
                i++;
            }
        }

        maxLen = Math.max(maxLen, j - i);

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }
}
