package byx.leetcode.problem.丢失的数字;

/**
 * https://leetcode-cn.com/problems/missing-number/
 */
public class Solution1 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
