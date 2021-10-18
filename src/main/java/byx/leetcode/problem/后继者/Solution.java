package byx.leetcode.problem.后继者;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/successor-lcci/
 */
public class Solution {
    private TreeNode p;
    private TreeNode last;
    private TreeNode result;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.p = p;
        try {
            inorder(root);
        } catch (RuntimeException e) {}
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (last == p) {
            result = root;
            throw new RuntimeException();
        }
        last = root;

        inorder(root.right);
    }
}
