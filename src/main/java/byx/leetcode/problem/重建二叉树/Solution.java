package byx.leetcode.problem.重建二叉树;

import byx.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int b1, int e1, int[] inorder, int b2, int e2) {
        if (b1 > e1 || b2 > e2) {
            return null;
        }

        if (b1 == e1) {
            return new TreeNode(preorder[b1]);
        }

        int rootVal = preorder[b1];

        int mid;
        for (mid = b2; mid <= e2; ++mid) {
            if (inorder[mid] == rootVal) {
                break;
            }
        }

        int cLeft = mid - b2;
        int cRight = e2 - mid;
        TreeNode left = build(preorder, b1 + 1, b1 + cLeft, inorder, b2, mid - 1);
        TreeNode right = build(preorder, e1 - cRight + 1, e1, inorder, mid + 1, e2);

        return new TreeNode(rootVal, left, right);
    }
}
