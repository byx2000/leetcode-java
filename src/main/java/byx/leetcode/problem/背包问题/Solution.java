package byx.leetcode.problem.背包问题;

/**
 * https://www.lintcode.com/problem/92/description
 */
public class Solution {
    public int backPack(int capacity, int[] weights) {
        Integer[][] cache = new Integer[capacity + 1][weights.length];
        return capacity - dp(weights, cache, capacity, 0);
    }

    private int dp(int[] weights, Integer[][] cache, int capacity, int index) {
        if (index == weights.length) {
            return capacity;
        }

        if (cache[capacity][index] != null) {
            return cache[capacity][index];
        }

        int res = dp(weights, cache, capacity, index + 1);
        if (capacity >= weights[index]) {
            res = Math.min(res, dp(weights, cache, capacity - weights[index], index + 1));
        }

        return cache[capacity][index] = res;
    }
}
