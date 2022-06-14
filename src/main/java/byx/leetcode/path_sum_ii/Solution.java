package byx.leetcode.path_sum_ii;

// https://leetcode.cn/problems/path-sum-ii/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }

        this.targetSum = targetSum;
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, new LinkedList<>(), result);
        return result;
    }

    private void dfs(TreeNode n, int sum, LinkedList<Integer> path, List<List<Integer>> result) {
        if (n == null) {
            return;
        }

        if (n.left == null && n.right == null) {
            if (sum + n.val == targetSum) {
                path.add(n.val);
                result.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }

        path.add(n.val);
        dfs(n.left, sum + n.val, path, result);
        dfs(n.right, sum + n.val, path, result);
        path.removeLast();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of(5, 4, 11, 2),
                List.of(5, 8, 4, 5)
        ), new HashSet<>(s.pathSum(TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22)));
        assertEquals(Set.of(), new HashSet<>(s.pathSum(TreeNode.build(1, 2, 3), 5)));
        assertEquals(Set.of(), new HashSet<>(s.pathSum(TreeNode.build(1, 2), 0)));
        assertEquals(Set.of(), new HashSet<>(s.pathSum(TreeNode.build(1, 2), 1)));
    }
}
