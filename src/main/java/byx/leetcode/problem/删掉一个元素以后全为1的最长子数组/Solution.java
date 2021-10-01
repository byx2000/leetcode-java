package byx.leetcode.problem.删掉一个元素以后全为1的最长子数组;

/**
 * https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int c0 = 0;
        int maxLen = 0;

        while (j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                if (c0 == 0) {
                    c0 = 1;
                    j++;
                } else {
                    maxLen = Math.max(maxLen, j - i);
                    if (nums[i] == 0) {
                        c0 = 0;
                    }
                    i++;
                }
            }
        }

        maxLen = Math.max(maxLen, j - i);

        return maxLen - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(solution.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(solution.longestSubarray(new int[]{1, 1, 1}));
        System.out.println(solution.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        System.out.println(solution.longestSubarray(new int[]{0, 0, 0}));
    }
}
