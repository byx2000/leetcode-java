package byx.leetcode.minimum_size_subarray_sum;

// https://leetcode.cn/problems/minimum-size-subarray-sum/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (j < nums.length) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }
            while (sum >= target) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i];
                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(1, s.minSubArrayLen(4, new int[]{1, 4, 4}));
        assertEquals(0, s.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
