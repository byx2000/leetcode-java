package byx.leetcode.problem.二叉树中所有距离为K的结点;

import byx.leetcode.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 将树转换成无向图
        Map<TreeNode, Set<TreeNode>> adj = new HashMap<>();
        inorder(root, adj);

        // BFS
        Queue<TreeNode> queue = new LinkedList<>(List.of(target));
        Set<TreeNode> book = new HashSet<>(Set.of(target));

        while (!queue.isEmpty()) {
            if (k == 0) {
                break;
            }

            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode n = queue.remove();
                for (TreeNode m : adj.get(n)) {
                    if (!book.contains(m)) {
                        queue.add(m);
                        book.add(m);
                    }
                }
            }

            k--;
        }

        return queue.stream().map(n -> n.val).collect(Collectors.toList());
    }

    private void inorder(TreeNode root, Map<TreeNode, Set<TreeNode>> adj) {
        if (root == null) {
            return;
        }

        if (!adj.containsKey(root)) {
            adj.put(root, new HashSet<>());
        }

        if (root.left != null) {
            addEdge(adj, root, root.left);
            addEdge(adj, root.left, root);
        }

        if (root.right != null) {
            addEdge(adj, root, root.right);
            addEdge(adj, root.right, root);
        }

        inorder(root.left, adj);
        inorder(root.right, adj);
    }

    private void addEdge(Map<TreeNode, Set<TreeNode>> adj, TreeNode start, TreeNode end) {
        if (adj.containsKey(start)) {
            adj.get(start).add(end);
        } else {
            adj.put(start, new HashSet<>(Set.of(end)));
        }
    }
}
