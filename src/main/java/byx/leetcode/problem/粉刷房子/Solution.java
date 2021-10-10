package byx.leetcode.problem.粉刷房子;

/**
 * https://leetcode-cn.com/problems/JEj789/
 */
public class Solution {
    private Integer[][] cache;

    public int minCost(int[][] nums) {
        int minVal = Integer.MAX_VALUE;
        cache = new Integer[nums.length][nums[0].length];

        for (int i = 0; i < nums[0].length; ++i) {
            minVal = Math.min(minVal, dp(nums, 0, i));
        }

        return minVal;
    }

    private int dp(int[][] nums, int r, int c) {
        if (cache[r][c] != null) {
            return cache[r][c];
        }

        if (r == nums.length - 1) {
            return cache[r][c] = nums[r][c];
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums[r].length; ++i) {
            if (i != c) {
                minVal = Math.min(minVal, nums[r][c] + dp(nums, r + 1, i));
            }
        }

        return cache[r][c] = minVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(solution.minCost(new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}}));
    }
}
