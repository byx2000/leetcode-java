package byx.leetcode.problem.只出现一次的数字;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
