package byx.leetcode.problem.序列化与反序列化二叉树;

import byx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        serialize(root, result);
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(list);
    }

    private void serialize(TreeNode n, List<String> result) {
        if (n == null) {
            result.add("null");
            return;
        }

        result.add(String.valueOf(n.val));
        serialize(n.left, result);
        serialize(n.right, result);
    }

    private TreeNode deserialize(List<String> data) {
        if ("null".equals(data.get(0))) {
            data.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data.get(0)));
        data.remove(0);
        node.left = deserialize(data);
        node.right = deserialize(data);

        return node;
    }
}
