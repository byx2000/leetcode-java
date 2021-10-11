package byx.leetcode.problem.二叉树的直径;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int len = maxLengthToLeaf(root.left) + maxLengthToLeaf(root.right);
        len = Math.max(len, diameterOfBinaryTree(root.left));
        len = Math.max(len, diameterOfBinaryTree(root.right));

        return len;
    }

    private int maxLengthToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxLengthToLeaf(root.left), maxLengthToLeaf(root.right));
    }
}
