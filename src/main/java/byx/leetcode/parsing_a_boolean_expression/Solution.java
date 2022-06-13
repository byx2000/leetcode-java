package byx.leetcode.parsing_a_boolean_expression;

// https://leetcode.cn/problems/parsing-a-boolean-expression/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    private String expr;
    private int index;

    public boolean parseBoolExpr(String expression) {
        this.expr = expression;
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

    private boolean parseBool() {
        return next() == 't';
    }

    private boolean parseAndExpr() {
        next(); // 读取'&'
        next(); // 读取'('
        boolean r = parseExpr();
        while (peek() == ',') {
            next(); // 读取','
            boolean r2 = parseExpr();
            r = r && r2;
        }
        next(); // 读取')'
        return r;
    }

    private boolean parseOrExpr() {
        next(); // 读取'|'
        next(); // 读取'('
        boolean r = parseExpr();
        while (peek() == ',') {
            next(); // 读取','
            boolean r2 = parseExpr();
            r = r || r2;
        }
        next(); // 读取')'
        return r;
    }

    private boolean parseNotExpr() {
        next(); // 读取'!'
        next(); // 读取'('
        boolean r = !parseExpr();
        next(); // 读取')'
        return r;
    }

    private boolean parseExpr() {
        char c = peek();
        if (c == 't' || c == 'f') {
            return parseBool();
        } else if (c == '&') {
            return parseAndExpr();
        } else if (c == '|') {
            return parseOrExpr();
        } else if (c == '!') {
            return parseNotExpr();
        } else {
            throw new RuntimeException("unexpected character: " + c);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.parseBoolExpr("!(f)"));
        assertTrue(s.parseBoolExpr("|(f,t)"));
        assertFalse(s.parseBoolExpr("&(t,f)"));
        assertFalse(s.parseBoolExpr("|(&(t,f,t),!(t))"));
        assertFalse(s.parseBoolExpr("&(&(&(!(&(f)),&(t),|(f,f,t)),|(t),|(f,f,t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))),&(!(&(&(!(&(f)),&(t),|(f,f,t)),|(t),|(f,f,t))),!(&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))))),!(&(f))))"));
    }
}
