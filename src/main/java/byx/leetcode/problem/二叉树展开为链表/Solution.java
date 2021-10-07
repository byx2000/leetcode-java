package byx.leetcode.problem.二叉树展开为链表;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {
    private TreeNode last;

    private void preorder(TreeNode n) {
        if (n == null) {
            return;
        }

        TreeNode t1 = n.left;
        TreeNode t2 = n.right;
        last.right = n;
        last = n;
        n.left = null;

        preorder(t1);
        preorder(t2);
    }

    public void flatten(TreeNode root) {
        last = new TreeNode();
        preorder(root);
    }
}
