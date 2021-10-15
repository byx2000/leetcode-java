package byx.leetcode.problem.删除有序数组中的重复项II;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, k = 0;

        while (i < nums.length) {
            int j = i;
            int cnt = 0;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
                cnt++;
            }

            nums[k++] = nums[i];
            if (cnt > 1) {
                nums[k++] = nums[i];
            }

            i = j;
        }

        return k;
    }
}
