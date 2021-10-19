package byx.leetcode.problem.跳跃游戏II;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 99999;
            for (int j = 0; j < i; ++j) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
