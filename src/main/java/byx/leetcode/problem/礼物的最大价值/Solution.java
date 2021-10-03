package byx.leetcode.problem.礼物的最大价值;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class Solution {
    private Integer[][] cache;

    public int maxValue(int[][] nums) {
        cache = new Integer[nums.length][nums[0].length];
        return dp(nums, nums.length - 1, nums[0].length - 1);
    }

    // nums[0][0]~nums[i][j]最大价值
    private int dp(int[][] nums, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == 0 && j == 0) {
            return cache[i][j] = nums[0][0];
        }

        if (i == 0) {
            return cache[i][j] = nums[i][j] + dp(nums, 0, j - 1);
        }

        if (j == 0) {
            return cache[i][j] = nums[i][j] + dp(nums, i - 1, 0);
        }

        return cache[i][j] = nums[i][j] + Math.max(dp(nums, i - 1, j), dp(nums, i, j - 1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
