package byx.leetcode.problem.数组划分II;

/**
 * https://www.lintcode.com/problem/625/description
 */
public class Solution {
    public void partition2(int[] nums, int low, int high) {
        int i = 0, j = nums.length - 1, k = 0;
        while (k <= j) {
            if (nums[k] < low) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k] > high) {
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
}
