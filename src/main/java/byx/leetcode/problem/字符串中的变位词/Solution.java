package byx.leetcode.problem.字符串中的变位词;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/MPnaiL/
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
            m2.put(s2.charAt(i), m2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (m1.equals(m2)) {
            return true;
        }

        for (int i = 0; i + s1.length() < s2.length(); ++i) {
            char c1 = s2.charAt(i);
            int cnt = m2.get(c1);
            if (cnt == 1) {
                m2.remove(c1);
            } else {
                m2.put(c1, cnt - 1);
            }

            char c2 = s2.charAt(i + s1.length());
            m2.put(c2, m2.getOrDefault(c2, 0) + 1);

            if (m1.equals(m2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}
