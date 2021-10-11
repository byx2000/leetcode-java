package byx.leetcode.problem.路径总和;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
