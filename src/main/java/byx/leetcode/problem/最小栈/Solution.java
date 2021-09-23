package byx.leetcode.problem.最小栈;

import java.util.Stack;

class MinStack {
    private final Stack<Integer> values = new Stack<>();
    private final Stack<Integer> minValues = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        values.push(val);
        if (minValues.isEmpty()) {
            minValues.push(val);
        } else {
            minValues.push(Math.min(val, minValues.peek()));
        }
    }

    public void pop() {
        values.pop();
        minValues.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minValues.peek();
    }
}

public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
