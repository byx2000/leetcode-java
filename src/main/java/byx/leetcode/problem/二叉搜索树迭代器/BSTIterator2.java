package byx.leetcode.problem.二叉搜索树迭代器;

import byx.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/kTOapQ/
 */
public class BSTIterator2 {
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private final Stack<Frame> stack = new Stack<>();

    public BSTIterator2(TreeNode root) {
        if (root != null) {
            stack.push(new Frame(root, 0));
        }
    }

    public int next() {
        while (!stack.empty()) {
            Frame cur = stack.peek();
            TreeNode node = cur.node;
            int state = cur.state;

            if (state == 0) {
                cur.state = 1;
                if (node.left != null) {
                    stack.push(new Frame(node.left, 0));
                }
            } else if (state == 1) {
                stack.pop();
                if (node.right != null) {
                    stack.push(new Frame(node.right, 0));
                }
                return node.val;
            }
        }

        throw new RuntimeException();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
