package byx.leetcode.coin_change_2;

// https://leetcode.cn/problems/coin-change-2/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private int[] coins;
    private Integer[][] cache;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.cache = new Integer[coins.length][amount + 1];
        return dp(coins.length - 1, amount);
    }

    // 使用coins[0~index]凑出金额sum的方案数
    private int dp(int index, int sum) {
        if (cache[index][sum] != null) {
            return cache[index][sum];
        }

        if (index == 0) {
            return cache[index][sum] = sum % coins[0] == 0 ? 1 : 0;
        }

        // 不选择coins[index]
        int r1 = dp(index - 1, sum);

        // 选择coins[index]
        int r2 = 0;
        if (sum >= coins[index]) {
            r2 = dp(index, sum - coins[index]);
        }

        return cache[index][sum] = r1 + r2;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.change(5, new int[]{1, 2, 5}));
        assertEquals(0, s.change(3, new int[]{2}));
        assertEquals(1, s.change(10, new int[]{10}));
    }
}
