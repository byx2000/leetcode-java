package byx.leetcode.problem.最长定差子序列;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Solution3 {
    public int longestSubsequence(int[] nums, int d) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        int maxLen = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (map.containsKey(nums[i] - d)) {
                dp[i] = map.get(nums[i] - d) + 1;
            } else {
                dp[i] = 1;
            }
            map.put(nums[i], dp[i]);
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(solution.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(solution.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
