package byx.leetcode.problem.二叉树的后序遍历;

import byx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class Solution {
    private static class Frame {
        public TreeNode node;
        public int state;

        public Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Solution.Frame> stack = new Stack<>();
        stack.push(new Solution.Frame(root, 0));
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            Solution.Frame cur = stack.peek();

            if (cur.node == null) {
                stack.pop();
                continue;
            }

            if (cur.state == 0) {
                cur.state = 1;
                stack.push(new Solution.Frame(cur.node.left, 0));
            } else if (cur.state == 1) {
                cur.state = 2;
                stack.push(new Solution.Frame(cur.node.right, 0));
            } else {
                result.add(cur.node.val);
                stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(
                new TreeNode(
                        1,
                        null,
                        new TreeNode(
                                2,
                                new TreeNode(3),
                                null
                        )
                )));
    }
}
