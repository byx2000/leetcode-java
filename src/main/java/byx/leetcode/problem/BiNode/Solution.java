package byx.leetcode.problem.BiNode;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binode-lcci/
 */
public class Solution {
    private TreeNode last;

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode();
        last = head;
        inorder(root);
        return head.right;
    }

    private void inorder(TreeNode n) {
        if (n == null) {
            return;
        }

        inorder(n.left);

        last.right = n;
        n.left = null;
        last = n;

        inorder(n.right);
    }
}
