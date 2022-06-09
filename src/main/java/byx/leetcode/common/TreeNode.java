package byx.leetcode.common;

/**
 * 二叉树节点
 */
public class TreeNode {
    public final int val;
    public final TreeNode left, right;

    public TreeNode() {
        this(0, null, null);
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
