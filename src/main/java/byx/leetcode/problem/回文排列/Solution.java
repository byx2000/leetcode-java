package byx.leetcode.problem.回文排列;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        for (int c : map.values()) {
            if (c % 2 == 1) {
                cnt++;
            }
        }

        return cnt == 0 || cnt == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("tactcoa"));
    }
}
