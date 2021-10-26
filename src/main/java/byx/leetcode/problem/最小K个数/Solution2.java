package byx.leetcode.problem.最小K个数;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class Solution2 {
    public int[] smallestK(int[] nums, int k) {
        if (k == 0) {
            return new int[]{};
        }

        int left = 0, right = nums.length - 1;
        while (true) {
            int mid = partition(nums, left, right);
            if (mid == k - 1) {
                return Arrays.copyOf(nums, k);
            } else if (mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int partition(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && nums[i] < nums[left]) { i++; }
            while (i <= j && nums[j] >= nums[left]) { j--; }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }
}
