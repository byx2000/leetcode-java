package byx.leetcode.problem.买卖股票的最佳时机;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[] minVal = new int[prices.length];
        minVal[0] = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            minVal[i] = Math.min(minVal[i - 1], prices[i]);
        }

        int result = 0;
        for (int i = 1; i < prices.length; ++i) {
            result = Math.max(result, prices[i] - minVal[i - 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}
