package byx.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import byx.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 使用preorder[i~j]和inorder[m~n]构建二叉树，保证 j - i == n - m
    private TreeNode build(int[] preorder, int i, int j, int[] inorder, int m, int n) {
        // 空二叉树
        if (i > j) {
            return null;
        }

        // 只有一个节点
        if (i == j) {
            return new TreeNode(preorder[i]);
        }

        // 根节点为前序遍历的第一个元素
        int root = preorder[i];

        // 在中序遍历中找到根节点，根节点左边为左子树元素，右边为右子树元素
        // k为根节点在inorder中的下标
        int k = m;
        for (; k <= n; k++) {
            if (inorder[k] == root) {
                break;
            }
        }

        // 递归构建左子树和右子树
        TreeNode left = build(preorder, i + 1, i + k - m, inorder, m, k - 1);
        TreeNode right = build(preorder, i + k - m + 1, j, inorder, k + 1, n);

        // 返回构建的二叉树
        return new TreeNode(root, left, right);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(TreeNode.build(3, 9, 20, null, null, 15, 7), s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        assertEquals(TreeNode.build(-1), s.buildTree(new int[]{-1}, new int[]{-1}));
    }
}
