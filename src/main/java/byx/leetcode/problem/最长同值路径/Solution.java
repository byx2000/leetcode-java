package byx.leetcode.problem.最长同值路径;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int len = longestUnivaluePathStartWith(root.left, root.val) + longestUnivaluePathStartWith(root.right, root.val);
        len = Math.max(len, longestUnivaluePath(root.left));
        len = Math.max(len, longestUnivaluePath(root.right));

        return len;
    }

    private int longestUnivaluePathStartWith(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        if (root.val != val) {
            return 0;
        }

        return 1 + Math.max(longestUnivaluePathStartWith(root.left, val), longestUnivaluePathStartWith(root.right, val));
    }
}
