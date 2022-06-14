package byx.leetcode.path_sum;

// https://leetcode.cn/problems/path-sum/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.hasPathSum(TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22));
        assertFalse(s.hasPathSum(TreeNode.build(1, 2, 3), 5));
        assertFalse(s.hasPathSum(TreeNode.build(), 0));
    }
}
