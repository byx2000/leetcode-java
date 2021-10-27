package byx.leetcode.problem.切棍子的最小成本;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/
 */
public class Solution {
    private Integer[][] cache;

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] nums = new int[cuts.length + 2];
        nums[0] = 0;
        for (int i = 1; i <= nums.length - 2; ++i) {
            nums[i] = cuts[i - 1];
        }
        nums[nums.length - 1] = n;

        cache = new Integer[nums.length][nums.length];
        return dp(nums, 0, nums.length - 1);
    }

    private int dp(int[] nums, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == j || i + 1 == j) {
            return cache[i][j] = 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k <= j - 1; ++k) {
            res = Math.min(res, dp(nums, i, k) + dp(nums, k, j) + nums[j] - nums[i]);
        }

        return cache[i][j] = res;
    }
}
