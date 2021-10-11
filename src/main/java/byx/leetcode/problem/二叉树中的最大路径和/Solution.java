package byx.leetcode.problem.二叉树中的最大路径和;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int s = root.val;
        int s1 = maxPathSumStartWith(root.left);
        int s2 = maxPathSumStartWith(root.right);
        if (s1 > 0) {
            s += s1;
        }
        if (s2 > 0) {
            s += s2;
        }

        return Math.max(s, Math.max(maxPathSum(root.left), maxPathSum(root.right)));
    }

    private int maxPathSumStartWith(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        return Math.max(root.val, root.val + Math.max(maxPathSumStartWith(root.left), maxPathSumStartWith(root.right)));
    }
}
