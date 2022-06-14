package byx.leetcode.path_sum_iii;

// https://leetcode.cn/problems/path-sum-iii/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return count(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    // 以节点n开头的和为sum的路径数量
    private int count(TreeNode n, int sum) {
        if (n == null) {
            return 0;
        }

        int r = count(n.left, sum - n.val) + count(n.right, sum - n.val);
        if (n.val == sum) {
            r++;
        }

        return r;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.pathSum(TreeNode.build(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8));
        assertEquals(3, s.pathSum(TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
    }
}
