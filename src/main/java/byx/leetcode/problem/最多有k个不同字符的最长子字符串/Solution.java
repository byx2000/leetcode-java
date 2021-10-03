package byx.leetcode.problem.最多有k个不同字符的最长子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/386/
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;

        while (j < s.length()) {
            if (map.size() <= k) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                maxLen = Math.max(maxLen, j - i);
                j++;
            } else {
                char c = s.charAt(i);
                int cnt = map.get(c);
                if (cnt == 1) {
                    map.remove(c);
                } else {
                    map.put(c, cnt - 1);
                }
                i++;
            }
        }

        if (map.size() <= k) {
            maxLen = Math.max(maxLen, j - i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("a", 1));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba", 3));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("WORLD", 4));
    }
}
