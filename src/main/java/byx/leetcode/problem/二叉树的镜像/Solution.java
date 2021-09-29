package byx.leetcode.problem.二叉树的镜像;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        return root;
    }
}
