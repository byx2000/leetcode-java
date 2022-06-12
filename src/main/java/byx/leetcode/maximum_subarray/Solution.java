package byx.leetcode.maximum_subarray;

// https://leetcode.cn/problems/maximum-subarray/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp);
        }

        return maxSum;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, s.maxSubArray(new int[]{1}));
        assertEquals(23, s.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
