package byx.leetcode.problem.最小高度树;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        return new TreeNode(nums[mid], build(nums, left, mid - 1), build(nums, mid + 1, right));
    }
}
