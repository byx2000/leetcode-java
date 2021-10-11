package byx.leetcode.problem.路径总和III;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return pathSumStartWith(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int pathSumStartWith(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int cnt = root.val == targetSum ? 1 : 0;
        return cnt + pathSumStartWith(root.left, targetSum - root.val) + pathSumStartWith(root.right, targetSum - root.val);
    }
}
