package byx.leetcode.problem.背包问题VII;

/**
 * https://www.lintcode.com/problem/798/description
 */
public class Solution {
    private Integer[][] cache;

    public int backPackVII(int n, int[] prices, int[] weights, int[] amounts) {
        cache = new Integer[prices.length][n + 1];
        return dp(prices, weights, amounts, 0, n);
    }

    private int dp(int[] prices, int[] weights, int[] amounts, int index, int n) {
        if (index == prices.length) {
            return 0;
        }

        if (cache[index][n] != null) {
            return cache[index][n];
        }

        int res = dp(prices, weights, amounts, index + 1, n);
        for (int i = 1; i <= amounts[index]; ++i) {
            if (n >= i * prices[index]) {
                res = Math.max(res, i * weights[index] + dp(prices, weights, amounts, index + 1, n - i * prices[index]));
            }
        }

        return cache[index][n] = res;
    }
}
