package byx.leetcode.problem.判定字符是否唯一;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class Solution {
    public boolean isUnique(String s) {
        int flag = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int offset = c - 'a';
            if (((1 << offset) & flag) != 0) {
                return false;
            }
            flag |= (1 << offset);
        }
        return true;
    }
}
