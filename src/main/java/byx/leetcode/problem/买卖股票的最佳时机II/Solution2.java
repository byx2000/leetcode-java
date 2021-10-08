package byx.leetcode.problem.买卖股票的最佳时机II;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int[] hasStock = new int[prices.length];
        int[] noStock = new int[prices.length];

        hasStock[0] = -prices[0];
        noStock[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            hasStock[i] = Math.max(hasStock[i - 1], noStock[i - 1] - prices[i]);
            noStock[i] = Math.max(noStock[i - 1], hasStock[i - 1] + prices[i]);
        }

        return Math.max(hasStock[prices.length - 1], noStock[prices.length - 1]);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
