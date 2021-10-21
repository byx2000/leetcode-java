package byx.leetcode.problem.数组划分;

/**
 * https://www.lintcode.com/problem/31
 */
public class Solution {
    public int partitionArray(int[] nums, int k) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < k) {
                swap(nums, i, j);
                j++;
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
