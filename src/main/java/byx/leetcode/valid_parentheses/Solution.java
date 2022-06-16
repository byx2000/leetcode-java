package byx.leetcode.valid_parentheses;

// https://leetcode.cn/problems/valid-parentheses/

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValid("()"));
        assertTrue(s.isValid("()[]{}"));
        assertFalse(s.isValid("(]"));
        assertFalse(s.isValid("([)]"));
        assertTrue(s.isValid("{[]}"));
    }
}
