package byx.leetcode.problem.删除有序数组中的重复项;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, k = 0;

        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }

            nums[k++] = nums[i];
            i = j;
        }

        return k;
    }
}
