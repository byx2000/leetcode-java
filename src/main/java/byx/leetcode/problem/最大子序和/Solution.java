package byx.leetcode.problem.最大子序和;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{0}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-100000}));
    }
}
