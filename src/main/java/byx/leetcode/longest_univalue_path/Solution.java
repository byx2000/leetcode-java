package byx.leetcode.longest_univalue_path;

// https://leetcode.cn/problems/longest-univalue-path/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int r = longestPath(root.left, root.val) + longestPath(root.right, root.val);
        r = Math.max(r, longestUnivaluePath(root.left));
        r = Math.max(r, longestUnivaluePath(root.right));

        return r;
    }

    // 以节点n开头且值为val的最长同值路径长度
    private int longestPath(TreeNode n, int val) {
        if (n == null || n.val != val) {
            return 0;
        }

        return 1 + Math.max(longestPath(n.left, val), longestPath(n.right, val));
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.longestUnivaluePath(TreeNode.build(5, 4, 5, 1, 1, 5)));
        assertEquals(2, s.longestUnivaluePath(TreeNode.build(1, 4, 5, 4, 4, 5)));
    }
}
