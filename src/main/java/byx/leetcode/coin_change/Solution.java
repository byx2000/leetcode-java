package byx.leetcode.coin_change;

// https://leetcode.cn/problems/coin-change/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private int[] coins;
    private Integer[][] cache;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new Integer[coins.length][amount + 1];
        return dp(coins.length - 1, amount);
    }

    // 使用coins[0~index]凑出sum的最少硬币个数
    private int dp(int index, int sum) {
        if (cache[index][sum] != null) {
            return cache[index][sum];
        }

        if (index == 0) {
            return cache[index][sum] = sum % coins[0] == 0 ? sum / coins[0] : -1;
        }

        // 不使用coins[index]
        int r1 = dp(index - 1, sum);

        // 使用coins[index]
        int r2 = -1;
        if (sum >= coins[index]) {
            r2 = dp(index, sum - coins[index]);
        }

        if (r1 == -1 && r2 == -1) {
            return cache[index][sum] = -1;
        } else if (r1 == -1) {
            return cache[index][sum] = 1 + r2;
        } else if (r2 == -1) {
            return cache[index][sum] = r1;
        } else {
            return cache[index][sum] = Math.min(r1, 1 + r2);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, s.coinChange(new int[]{2}, 3));
        assertEquals(0, s.coinChange(new int[]{1}, 0));
    }
}
