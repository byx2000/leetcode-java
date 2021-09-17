package byx.leetcode.problem.排序数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(nums, left, right);
        qsort(nums, left, mid - 1);
        qsort(nums, mid + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int partition(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && nums[i] < nums[left]) i++;
            while (i <= j && nums[j] >= nums[left]) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5,1,1,2,0,0})));
    }
}
