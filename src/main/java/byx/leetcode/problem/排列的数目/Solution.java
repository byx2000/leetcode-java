package byx.leetcode.problem.排列的数目;

/**
 * https://leetcode-cn.com/problems/D0F0SV/
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; ++i) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{9}, 3));
    }
}
