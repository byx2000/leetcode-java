package byx.leetcode.problem.二叉树的完全性检验;

import byx.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        boolean flag = false;

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode n = queue.remove();
                if (n == null) {
                    flag = true;
                } else {
                    if (flag) {
                        return false;
                    }
                    queue.add(n.left);
                    queue.add(n.right);
                }
            }
        }

        return true;
    }
}
