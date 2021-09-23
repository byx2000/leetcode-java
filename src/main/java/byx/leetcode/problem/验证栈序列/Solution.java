package byx.leetcode.problem.验证栈序列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-stack-sequences/
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int i = 0, j = 0;
        try {
            while (i < n) {
                while (pushed[i] != popped[j]) {
                    stack.push(pushed[i]);
                    i++;
                }
                j++;
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
                i++;
            }
        } catch (RuntimeException e) {
            return false;
        }

        while (!stack.isEmpty() && stack.peek() == popped[j]) {
            j++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
