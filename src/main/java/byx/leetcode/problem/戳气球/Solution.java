package byx.leetcode.problem.戳气球;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 */
public class Solution {
    private Integer[][] cache;

    public int maxCoins(int[] nums) {
        int[] nums2 = new int[nums.length + 2];
        nums2[0] = 1;
        for (int i = 1; i <= nums2.length - 2; ++i) {
            nums2[i] = nums[i - 1];
        }
        nums2[nums2.length - 1] = 1;

        cache = new Integer[nums2.length][nums2.length];
        return dp(nums2, 0, nums2.length - 1);
    }

    private int dp(int[] nums, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i + 1 == j) {
            return cache[i][j] = 0;
        }

        if (i + 2 == j) {
            return cache[i][j] = nums[i] * nums[i + 1] * nums[j];
        }

        int maxScore = -1;
        for (int k = i + 1; k <= j - 1; ++k) {
            maxScore = Math.max(maxScore, dp(nums, i, k) + dp(nums, k, j) + nums[i] * nums[k] * nums[j]);
        }

        return cache[i][j] = maxScore;
    }
}
