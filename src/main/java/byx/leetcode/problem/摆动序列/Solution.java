package byx.leetcode.problem.摆动序列;

/**
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = down[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; ++i) {
            up[i] = down[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], 1 + down[j]);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], 1 + up[j]);
                }
            }
            maxLen = Math.max(maxLen, up[i]);
            maxLen = Math.max(maxLen, down[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
