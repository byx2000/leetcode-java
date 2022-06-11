package byx.leetcode.lowest_common_ancestor_of_a_binary_tree;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/

import byx.leetcode.common.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        if (root.left == null) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.right == null) {
            return lowestCommonAncestor(root.left, p, q);
        }

        boolean b1 = in(root.left, p);
        boolean b2 = in(root.right, p);
        boolean b3 = in(root.left, q);
        boolean b4 = in(root.right, q);

        if (b1 && b3) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (b2 && b4) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    // 判断节点n是否在子树root中
    private boolean in(TreeNode root, TreeNode n) {
        if (root == null) {
            return false;
        }

        if (root == n) {
            return true;
        }

        return in(root.left, n) || in(root.right, n);
    }
}
