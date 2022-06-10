package byx.leetcode.binary_tree_maximum_path_sum;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int maxPathSum(TreeNode root) {
        // 左右子树都为空
        if (root.left == null && root.right == null) {
            return root.val;
        }

        // 左子树为空，右子树不为空
        if (root.left == null) {
            return Math.max(maxSum(root), maxPathSum(root.right));
        }

        // 左子树不为空，右子树为空
        if (root.right == null) {
            return Math.max(maxSum(root), maxPathSum(root.left));
        }

        // 左右子树都不为空
        int r = Math.max(maxSum(root.left), 0) + Math.max(maxSum(root.right), 0) + root.val;
        r = Math.max(r, maxPathSum(root.left));
        r = Math.max(r, maxPathSum(root.right));

        return r;
    }

    // 以节点n为起点的最大路径和
    private int maxSum(TreeNode n) {
        // 左右子树都为空
        if (n.left == null && n.right == null) {
            return n.val;
        }

        // 左子树为空，右子树不为空
        if (n.left == null) {
            return Math.max(n.val, n.val + maxSum(n.right));
        }

        // 左子树不为空，右子树为空
        if (n.right == null) {
            return Math.max(n.val, n.val + maxSum(n.left));
        }

        // 左右子树都不为空
        return Math.max(n.val, n.val + Math.max(maxSum(n.left), maxSum(n.right)));
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.maxPathSum(TreeNode.build(1, 2)));
        assertEquals(6, s.maxPathSum(TreeNode.build(1, 2, 3)));
        assertEquals(42, s.maxPathSum(TreeNode.build(-10, 9, 20, null, null, 15, 7)));
        assertEquals(2, s.maxPathSum(TreeNode.build(2, -1)));
        assertEquals(48, s.maxPathSum(TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)));
        assertEquals(16, s.maxPathSum(TreeNode.build(9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6)));
    }
}
