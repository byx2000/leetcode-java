package byx.leetcode.problem.零钱兑换;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Solution {
    private Integer[][] cache;

    public int coinChange(int[] coins, int amount) {
        cache = new Integer[coins.length][amount + 1];
        return dp(coins, coins.length - 1, amount);
    }

    // 使用coins[0]~coins[index]兑换amount的最小硬币数
    private int dp(int[] coins, int index, int amount) {
        if (cache[index][amount] != null) {
            return cache[index][amount];
        }

        if (index == 0) {
            return cache[index][amount] = (amount % coins[0] != 0) ? -1 : amount / coins[0];
        }

        if (amount >= coins[index]) {
            int c1 = dp(coins, index - 1, amount);
            int c2 = dp(coins, index, amount - coins[index]);
            if (c1 == -1) {
                return cache[index][amount] = (c2 == -1) ? -1 : 1 + c2;
            } else {
                return cache[index][amount] = (c2 == -1) ? c1 : Math.min(c1, 1 + c2);
            }
        } else {
            return cache[index][amount] = dp(coins, index - 1, amount);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{429, 171, 485, 26, 381, 31, 290}, 8440));
    }
}
