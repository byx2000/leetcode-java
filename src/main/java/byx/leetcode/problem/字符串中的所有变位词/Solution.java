package byx.leetcode.problem.字符串中的所有变位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/VabMRr/
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < p.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);
            m1.put(c1, m1.getOrDefault(c1, 0) + 1);
            m2.put(c2, m2.getOrDefault(c2, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        int i = 0;
        for (; i + p.length() < s.length(); ++i) {
            if (m1.equals(m2)) {
                result.add(i);
            }

            char c1 = s.charAt(i);
            int cnt = m1.get(c1);
            if (cnt == 1) {
                m1.remove(c1);
            } else {
                m1.put(c1, cnt - 1);
            }

            char c2 = s.charAt(i + p.length());
            m1.put(c2, m1.getOrDefault(c2, 0) + 1);
        }

        if (m1.equals(m2)) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}
