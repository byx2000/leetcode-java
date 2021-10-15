package byx.leetcode.problem.二叉搜索树迭代器;

import byx.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/kTOapQ/
 */
public class BSTIterator {
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private final Stack<Frame> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        stack.push(new Frame(root, 0));
    }

    public int next() {
        while (!stack.empty()) {
            Frame cur = stack.peek();
            TreeNode node = cur.node;
            int state = cur.state;

            if (node == null) {
                stack.pop();
                continue;
            }

            if (state == 0) {
                cur.state = 1;
                stack.push(new Frame(node.left, 0));
            } else if (state == 1) {
                cur.state = 2;
                stack.push(new Frame(node.right, 0));
                return node.val;
            } else if (state == 2) {
                stack.pop();
            }
        }

        throw new RuntimeException();
    }

    public boolean hasNext() {
        while (!stack.empty()) {
            Frame cur = stack.peek();
            TreeNode node = cur.node;
            int state = cur.state;

            if (node == null) {
                stack.pop();
                continue;
            }

            if (state == 0) {
                cur.state = 1;
                stack.push(new Frame(node.left, 0));
            } else if (state == 1) {
                return true;
            } else if (state == 2) {
                stack.pop();
            }
        }

        return false;
    }
}
