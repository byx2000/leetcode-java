package byx.leetcode.problem.颜色分类;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length, i = 0;

        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
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
