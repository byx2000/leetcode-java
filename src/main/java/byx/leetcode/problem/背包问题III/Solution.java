package byx.leetcode.problem.背包问题III;

/**
 * https://www.lintcode.com/problem/440
 */
public class Solution {
    private Integer[][] cache;

    public int backPackIII(int[] weights, int[] values, int capacity) {
        cache = new Integer[capacity + 1][weights.length];
        return dp(weights, values, capacity, 0);
    }

    private int dp(int[] weights, int[] values, int capacity, int index) {
        if (index == weights.length) {
            return 0;
        }

        if (cache[capacity][index] != null) {
            return cache[capacity][index];
        }

        int res = dp(weights, values, capacity, index + 1);
        if (capacity >= weights[index]) {
            res = Math.max(res, values[index] + dp(weights, values, capacity - weights[index], index));
        }

        return cache[capacity][index] = res;
    }
}
