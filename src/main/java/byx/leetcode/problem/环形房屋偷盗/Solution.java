package byx.leetcode.problem.环形房屋偷盗;

/**
 * https://leetcode-cn.com/problems/PzWKhm/
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }

        return Math.max(solve(nums, 0, nums.length - 2), solve(nums, 1, nums.length - 1));
    }

    private int solve(int[] nums, int start, int end) {
        int[] dp = new int[end + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 3, 2}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{0}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }
}
