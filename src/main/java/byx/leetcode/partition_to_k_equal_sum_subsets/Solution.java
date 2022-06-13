package byx.leetcode.partition_to_k_equal_sum_subsets;

// https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    private int[] nums;
    private int k;
    private int target;
    private int[] sum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = Arrays.stream(nums).boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(n -> n)
                .toArray();
        this.k = k;

        int s = 0;
        for (int n : nums) {
            s += n;
        }

        if (s % k != 0) {
            return false;
        }

        this.target = s / k;
        this.sum = new int[k];

        return dfs(0);
    }

    private boolean dfs(int index) {
        if (index == nums.length) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (sum[i] + nums[index] <= target) {
                sum[i] += nums[index];
                if (dfs(index + 1)) {
                    return true;
                }
                sum[i] -= nums[index];
            }
        }

        return false;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        assertFalse(s.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
    }
}
