package byx.leetcode.problem.最长的斐波那契子序列的长度;

/**
 * https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class Solution2 {
    private Integer[][] cache;

    public int lenLongestFibSubseq(int[] nums) {
        cache = new Integer[nums.length][nums.length];
        int maxLen = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                maxLen = Math.max(maxLen, dp(nums, i, j));
            }
        }

        return (maxLen == 2) ? 0 : maxLen;
    }

    // 以nums[i]和nums[j]结尾的最长斐波那契子序列长度
    private int dp(int[] nums, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int maxLen = 2;
        for (int k = i - 1; k >= 0; --k) {
            if (nums[k] + nums[i] == nums[j]) {
                maxLen = 1 + Math.max(maxLen, dp(nums, k, i));
                break;
            }
        }
        return cache[i][j] = maxLen;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 3, 5}));
    }
}
