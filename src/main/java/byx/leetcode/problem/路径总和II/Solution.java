package byx.leetcode.problem.路径总和II;

import byx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        dfs(path, paths, root, targetSum);
        return paths;
    }

    private void dfs(List<Integer> path, List<List<Integer>> paths, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                paths.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        dfs(path, paths, root.left, sum - root.val);
        dfs(path, paths, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
