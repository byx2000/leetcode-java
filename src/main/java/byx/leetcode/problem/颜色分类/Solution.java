package byx.leetcode.problem.颜色分类;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, k = 0;
        while (k <= j) {
            if (nums[k] == 0) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k] == 2) {
                swap(nums, j, k);
                j--;
            } else {
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
