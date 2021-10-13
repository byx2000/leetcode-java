package byx.leetcode.problem.左右两边子数组的和相等;

/**
 * https://leetcode-cn.com/problems/tvdfij/
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i - 1] + nums[i];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            right[i] = right[i + 1] + nums[i];
        }

        for (int i = 0; i < nums.length; ++i) {
            int s1 = (i == 0) ? 0 : left[i - 1];
            int s2 = (i == nums.length - 1) ? 0 : right[i + 1];
            if (s1 == s2) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(solution.pivotIndex(new int[]{2, 1, -1}));
    }
}
