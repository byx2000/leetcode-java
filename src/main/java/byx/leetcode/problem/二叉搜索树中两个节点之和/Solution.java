package byx.leetcode.problem.二叉搜索树中两个节点之和;

import byx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/opLdQZ/
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
