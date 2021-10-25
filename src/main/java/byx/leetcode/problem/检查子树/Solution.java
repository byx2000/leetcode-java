package byx.leetcode.problem.检查子树;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 */
public class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }
        return same(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean same(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }

        if (t2 == null) {
            return t1 == null;
        }

        return t1.val == t2.val && same(t1.left, t2.left) && same(t1.right, t2.right);
    }
}
