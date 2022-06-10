package byx.leetcode.diameter_of_binary_tree;

// https://leetcode.cn/problems/diameter-of-binary-tree/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int r = longestPath(root.left) + longestPath(root.right);
        r = Math.max(r, diameterOfBinaryTree(root.left));
        r = Math.max(r, diameterOfBinaryTree(root.right));

        return r;
    }

    // 以节点n开头的最长路径长度
    public int longestPath(TreeNode n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.max(longestPath(n.left), longestPath(n.right));
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.diameterOfBinaryTree(TreeNode.build(1, 2, 3, 4, 5)));
    }
}
