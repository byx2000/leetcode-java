package byx.leetcode.problem.零钱兑换;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Solution {
    private Integer[][] cache;

    public int coinChange(int[] coins, int amount) {
        cache = new Integer[amount + 1][coins.length];
        return dp(coins, amount, 0);
    }

    private int dp(int[] coins, int amount, int index) {
        if (index == coins.length) {
            return amount == 0 ? 0 : -1;
        }

        if (cache[amount][index] != null) {
            return cache[amount][index];
        }

        int r1 = dp(coins, amount, index + 1);
        if (amount >= coins[index]) {
            int r2 = dp(coins, amount - coins[index], index);
            if (r1 == -1) {
                return cache[amount][index] = r2 == -1 ? -1 : 1 + r2;
            }  else if (r2 == -1) {
                return cache[amount][index] = r1;
            } else {
                return cache[amount][index] = Math.min(r1, 1 + r2);
            }
        }

        return cache[amount][index] = r1;
    }
}
