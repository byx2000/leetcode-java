package byx.leetcode.problem.下一个排列;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
