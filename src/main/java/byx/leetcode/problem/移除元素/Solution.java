package byx.leetcode.problem.移除元素;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
