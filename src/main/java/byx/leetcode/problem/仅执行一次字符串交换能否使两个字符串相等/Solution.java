package byx.leetcode.problem.仅执行一次字符串交换能否使两个字符串相等;

/**
 * https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/submissions/
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char c1 = ' ', c2 = ' ', c3 = ' ', c4 = ' ';
        int cnt = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (cnt == 0) {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                    cnt++;
                } else if (cnt == 1) {
                    if (c1 != s2.charAt(i) || c2 != s1.charAt(i)) {
                        return false;
                    }
                    cnt++;
                } else if (cnt == 2) {
                    return false;
                }
            }
        }

        return cnt == 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
        System.out.println(solution.areAlmostEqual("kelb", "kelb"));
        System.out.println(solution.areAlmostEqual("abcd", "dcba"));
    }
}
