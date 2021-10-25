package byx.leetcode.problem.背包问题IV;

/**
 * https://www.lintcode.com/problem/562
 */
public class Solution {
    private Integer[][] cache;

    public int backPackIV(int[] nums, int target) {
        cache = new Integer[target + 1][nums.length];
        return dp(nums, target, 0);
    }

    private int dp(int[] nums, int sum, int index) {
        if (index == nums.length) {
            return sum == 0 ? 1 : 0;
        }

        if (cache[sum][index] != null) {
            return cache[sum][index];
        }

        int res = dp(nums, sum, index + 1);
        if (sum >= nums[index]) {
            res += dp(nums, sum - nums[index], index);
        }

        return cache[sum][index] = res;
    }
}
