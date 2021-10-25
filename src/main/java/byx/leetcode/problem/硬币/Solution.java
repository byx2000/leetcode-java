package byx.leetcode.problem.硬币;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 */
public class Solution {
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        Integer[][] cache = new Integer[n + 1][coins.length];
        return dp(coins, cache, n, 0);
    }

    private int dp(int[] coins, Integer[][] cache, int n, int index) {
        if (index == coins.length) {
            return n == 0 ? 1 : 0;
        }

        if (n == 0) {
            return 1;
        }

        if (cache[n][index] != null) {
            return cache[n][index];
        }

        int result = dp(coins, cache, n, index + 1);
        if (n >= coins[index]) {
            result = (result + dp(coins, cache, n - coins[index], index)) % 1000000007;
        }

        return cache[n][index] = result;
    }
}
