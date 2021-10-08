package byx.leetcode.problem.最长定差子序列;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Solution1 {
    public int longestSubsequence(int[] nums, int d) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] - nums[j] == d) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(solution.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(solution.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
