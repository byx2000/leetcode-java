package byx.leetcode.problem.不相交的线;

/**
 * https://leetcode-cn.com/problems/uncrossed-lines/
 */
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return dp(nums1, nums2, new Integer[nums1.length][nums2.length], 0, 0);
    }

    private int dp(int[] nums1, int[] nums2, Integer[][] cache, int i, int j) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int result = Math.max(dp(nums1, nums2, cache, i + 1, j), dp(nums1, nums2, cache, i, j + 1));
        if (nums1[i] == nums2[j]) {
            result = Math.max(result, 1 + dp(nums1, nums2, cache, i + 1, j + 1));
        }

        return cache[i][j] = result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(solution.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(solution.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
        System.out.println(solution.maxUncrossedLines(new int[]{3, 1, 4, 1, 1, 3, 5, 1, 2, 2}, new int[]{4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3}));
    }
}
