package byx.leetcode.problem.数组中的最长山脉;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 */
public class Solution2 {
    public int longestMountain(int[] nums) {
        // up[i]表示以nums[i]结尾的最长上升子数组长度
        int[] up = new int[nums.length];
        up[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                up[i] = up[i - 1] + 1;
            } else {
                up[i] = 1;
            }
        }

        // down[i]表示以nums[i]开头的最长下降子数组长度
        int[] down = new int[nums.length];
        down[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] > nums[i + 1]) {
                down[i] = down[i + 1] + 1;
            } else {
                down[i] = 1;
            }
        }

        int maxLen = 0;
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                maxLen = Math.max(maxLen, up[i] + down[i] - 1);
            }
        }

        return maxLen;
    }
}
