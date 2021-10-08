package byx.leetcode.problem.可被三整除的最大和;

/**
 * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[3][nums.length];
        dp[nums[0] % 3][0] = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            for (int r = 0; r < 3; ++r) {
                dp[r][i] = dp[r][i - 1];
            }

            for (int r = 0; r < 3; ++r) {
                int t = dp[r][i - 1] + nums[i];
                dp[t % 3][i] = Math.max(dp[t % 3][i], t);
            }
        }

        return dp[0][nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(solution.maxSumDivThree(new int[]{4}));
        System.out.println(solution.maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }
}
