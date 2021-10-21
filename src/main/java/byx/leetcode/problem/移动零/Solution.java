package byx.leetcode.problem.移动零;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
