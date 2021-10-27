package byx.leetcode.problem.石子归并;

/**
 * https://www.lintcode.com/problem/476/?_from=problem_tag&fromId=undefined
 */
public class Solution {
    private Integer[][] cache;
    private int[] sum;

    public int stoneGame(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }

        cache = new Integer[nums.length][nums.length];
        return dp(nums, 0, nums.length - 1);
    }

    private int sum(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }

    private int dp(int[] nums, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == j) {
            return cache[i][j] = 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            res = Math.min(res, dp(nums, i, k) + dp(nums, k + 1, j) + sum(i, j));
        }

        return cache[i][j] = res;
    }
}
