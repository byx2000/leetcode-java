package byx.leetcode.serialize_and_deserialize_binary_tree;

// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Codec {
    public String serialize(TreeNode root) {
        List<String> nums = new ArrayList<>();
        preorder(root, nums);
        return String.join(",", nums);
    }

    private void preorder(TreeNode n, List<String> nums) {
        if (n == null) {
            nums.add("null");
            return;
        }

        nums.add(String.valueOf(n.val));
        preorder(n.left, nums);
        preorder(n.right, nums);
    }

    public TreeNode deserialize(String data) {
        String[] nums = data.split(",");
        return build(nums, new AtomicInteger(0));
    }

    private TreeNode build(String[] nums, AtomicInteger index) {
        if ("null".equals(nums[index.get()])) {
            index.getAndIncrement();
            return null;
        }

        int val = Integer.parseInt(nums[index.getAndIncrement()]);
        TreeNode left = build(nums, index);
        TreeNode right = build(nums, index);
        return new TreeNode(val, left, right);
    }

    @Test
    public void test() {
        Codec codec = new Codec();
        assertEquals(TreeNode.build(1, 2, 3, null, null, 4, 5), codec.deserialize(codec.serialize(TreeNode.build(1, 2, 3, null, null, 4, 5))));
        assertEquals(TreeNode.build(), codec.deserialize(codec.serialize(TreeNode.build())));
        assertEquals(TreeNode.build(1), codec.deserialize(codec.serialize(TreeNode.build(1))));
        assertEquals(TreeNode.build(1, 2), codec.deserialize(codec.serialize(TreeNode.build(1, 2))));
    }
}
