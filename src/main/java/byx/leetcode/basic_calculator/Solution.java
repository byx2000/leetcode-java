package byx.leetcode.basic_calculator;

// https://leetcode.cn/problems/basic-calculator/
// https://leetcode.cn/problems/basic-calculator-ii/
// https://www.lintcode.com/problem/849

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String expr;
    private int index;

    public int calculate(String s) {
        this.expr = s.replace(" ", "");
        this.index = 0;
        return parseExpr();
    }

    // 是否到达输入串末尾
    private boolean end() {
        return index == expr.length();
    }

    // 获取下一个字符
    private char peek() {
        return expr.charAt(index);
    }

    // 获取下一个字符，并向前移动一个字符
    private char next() {
        return expr.charAt(index++);
    }

    // 读取整数
    private int parseNum() {
        int num = 0;
        while (!end() && Character.isDigit(peek())) {
            num = num * 10 + (next() - '0');
        }
        return num;
    }

    // factor = num | (expr) | - factor
    private int parseFactor() {
        if (Character.isDigit(peek())) {
            return parseNum();
        } else if (peek() == '(') {
            next(); // 读取'('
            int r = parseExpr();
            next(); // 读取')'
            return r;
        } else if (peek() == '-') {
            next(); // 读取'-'
            return -parseFactor();
        }
        throw new RuntimeException("unexpected token: " + peek());
    }

    // term = factor (*|/ factor)*
    private int parseTerm() {
        int r = parseFactor();
        while (!end() && (peek() == '*' || peek() == '/')) {
            char op = next();
            if (op == '*') {
                r *= parseFactor();
            } else {
                r /= parseFactor();
            }
        }
        return r;
    }

    // expr = term (+|- term)*
    private int parseExpr() {
        int r = parseTerm();
        while (!end() && (peek() == '+' || peek() == '-')) {
            char op = next();
            if (op == '+') {
                r += parseTerm();
            } else {
                r -= parseTerm();
            }
        }
        return r;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.calculate("1 + 1"));
        assertEquals(3, s.calculate(" 2-1 + 2 "));
        assertEquals(23, s.calculate("(1+(4+5+2)-3)+(6+8)"));
        assertEquals(-1, s.calculate("-2+ 1"));
        assertEquals(7, s.calculate("3+2*2"));
        assertEquals(1, s.calculate(" 3/2 "));
        assertEquals(5, s.calculate(" 3+5 / 2 "));
    }
}
