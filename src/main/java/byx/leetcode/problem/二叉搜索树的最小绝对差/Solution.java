package byx.leetcode.problem.二叉搜索树的最小绝对差;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class Solution {
    private int last;
    private int minDiff;

    public int getMinimumDifference(TreeNode root) {
        last = -1;
        minDiff = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (last != -1) {
            minDiff = Math.min(minDiff, root.val - last);
        }
        last = root.val;

        inorder(root.right);
    }
}
