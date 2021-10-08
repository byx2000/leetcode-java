package byx.leetcode.problem.最长等差数列;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence/
 */
public class Solution1 {
    private Integer[][] cache;

    public int longestArithSeqLength(int[] nums) {
        cache = new Integer[nums.length][nums.length];
        int maxLen = 2;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                maxLen = Math.max(maxLen, dp(nums, i, j));
            }
        }

        return maxLen;
    }

    // 最后两项为nums[i]和nums[j]的最长等差数列的长度
    private int dp(int[] nums, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int maxLen = 2;
        for (int k = 0; k < i; ++k) {
            if (nums[k] - nums[i] == nums[i] - nums[j]) {
                maxLen = Math.max(maxLen, 1 + dp(nums, k, i));
            }
        }
        return cache[i][j] = maxLen;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(solution.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(solution.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }
}
