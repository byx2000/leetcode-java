package byx.leetcode.problem.丢失的数字;

/**
 * https://leetcode-cn.com/problems/missing-number/
 */
public class Solution2 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
