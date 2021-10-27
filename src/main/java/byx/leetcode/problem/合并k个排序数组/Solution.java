package byx.leetcode.problem.合并k个排序数组;

/**
 * https://www.lintcode.com/problem/486/description
 */
public class Solution {
    public int[] mergekSortedArrays(int[][] nums) {
        int[] result = new int[]{};
        for (int[] n : nums) {
            result = merge(result, n);
        }
        return result;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                nums[k++] = nums2[j++];
            } else if (j == nums2.length) {
                nums[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        return nums;
    }
}
