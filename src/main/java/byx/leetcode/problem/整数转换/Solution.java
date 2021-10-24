package byx.leetcode.problem.整数转换;

/**
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 */
public class Solution {
    public int convertInteger(int a, int b) {
        int r = a ^ b;
        int cnt = 0;
        while (r != 0) {
            cnt += r & 1;
            r >>>= 1;
        }
        return cnt;
    }
}
