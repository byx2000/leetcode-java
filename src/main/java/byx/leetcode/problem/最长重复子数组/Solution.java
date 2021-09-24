package byx.leetcode.problem.最长重复子数组;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class Solution {
    private Integer[][] cache;

    public int findLength(int[] nums1, int[] nums2) {
        cache = new Integer[nums1.length][nums2.length];
        int maxLen = 0;
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                maxLen = Math.max(maxLen, dp(nums1, i, nums2, j));
            }
        }
        return maxLen;
    }

    // 以nums1[i]和nums2[j]结尾的最长公共子数组长度
    private int dp(int[] nums1, int i, int[] nums2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (nums1[i] != nums2[j]) {
            return cache[i][j] = 0;
        } else {
            return cache[i][j] = 1 + dp(nums1, i - 1, nums2, j - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
