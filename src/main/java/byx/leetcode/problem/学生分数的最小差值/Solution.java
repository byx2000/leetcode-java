package byx.leetcode.problem.学生分数的最小差值;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; ++i) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }
}
