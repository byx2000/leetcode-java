package byx.leetcode.problem.最小划分;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/724
 */
public class Solution {
    private Integer[][] cache;

    public int findMin(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        cache = new Integer[sum / 2 + 1][nums.length];
        int minLeft = dp(nums, sum / 2, 0);
        int a = sum / 2 - minLeft;
        int b = sum - a;
        return b - a;
    }

    private int dp(int[] nums, int sum, int index) {
        if (index == nums.length) {
            return sum;
        }

        if (cache[sum][index] != null) {
            return cache[sum][index];
        }

        int res = dp(nums, sum, index + 1);
        if (sum >= nums[index]) {
            res = Math.min(res, dp(nums, sum - nums[index], index + 1));
        }

        return cache[sum][index] = res;
    }
}
