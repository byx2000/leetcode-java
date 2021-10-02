package byx.leetcode.problem.判定是否互为字符重排;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        return strToMap(s1).equals(strToMap(s2));
    }

    private Map<Character, Integer> strToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.CheckPermutation("abc", "bca"));
        System.out.println(solution.CheckPermutation("abc", "bad"));
    }
}
