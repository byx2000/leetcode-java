package byx.leetcode.partition_equal_subset_sum;

// https://leetcode.cn/problems/partition-equal-subset-sum/

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    private int[] nums;
    private Boolean[][] cache;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        this.nums = nums;
        this.cache = new Boolean[nums.length][sum / 2 + 1];
        return dp(nums.length - 1, sum / 2);
    }

    // 是否能从nums[0~index]中选取若干个数，使得它们的和恰好为sum
    private boolean dp(int index, int sum) {
        if (cache[index][sum] != null) {
            return cache[index][sum];
        }

        if (index == 0) {
            return cache[index][sum] = nums[index] == sum;
        }

        // 不选nums[index]
        if (dp(index - 1, sum)) {
            return cache[index][sum] = true;
        }

        // 选nums[index]
        return cache[index][sum] = sum >= nums[index] && dp(index - 1, sum - nums[index]);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canPartition(new int[]{1, 5, 11, 5}));
        assertFalse(s.canPartition(new int[]{1, 2, 3, 5}));
        assertFalse(s.canPartition(new int[]{1, 2, 5}));
    }
}
