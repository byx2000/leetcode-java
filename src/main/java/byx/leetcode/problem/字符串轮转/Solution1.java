package byx.leetcode.problem.字符串轮转;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 */
public class Solution1 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 0; i < s1.length(); ++i) {
            if (s2.equals(s1.substring(i) + s1.substring(0, i))) {
                return true;
            }
        }

        return false;
    }
}
