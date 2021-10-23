package byx.leetcode.problem.数组中的最长山脉;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 */
public class Solution1 {
    public int longestMountain(int[] nums) {
        int maxLen = 0;

        for (int i = 1; i < nums.length - 1; ++i) {
            int j = i - 1;
            while (j >= 0 && nums[j] < nums[j + 1]) {
                j--;
            }

            int k = i + 1;
            while (k < nums.length && nums[k] < nums[k - 1]) {
                k++;
            }

            if (j != i - 1 && k != i + 1) {
                maxLen = Math.max(maxLen, k - j - 1);
            }
        }

        return maxLen;
    }
}
