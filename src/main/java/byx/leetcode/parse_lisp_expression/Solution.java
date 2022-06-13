package byx.leetcode.parse_lisp_expression;

// https://leetcode.cn/problems/parse-lisp-expression/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String expr;
    private int index;

    public int evaluate(String expr) {
        this.expr = expr;
        this.index = 0;
        return parseExpr(new Scope(null));
    }

    // 作用域
    private static class Scope {
        private final Map<String, Integer> vars = new HashMap<>();
        private final Scope parent;

        // 创建一个作用域，父级作用域为parent
        public Scope(Scope parent) {
            this.parent = parent;
        }

        // 设置变量
        public void setVar(String name, int value) {
            vars.put(name, value);
        }

        // 获取变量的值
        public int getVar(String name) {
            Scope cur = this;
            while (cur != null) {
                if (cur.vars.containsKey(name)) {
                    return cur.vars.get(name);
                }
                cur = cur.parent;
            }
            throw new RuntimeException("unknown var: " + name);
        }
    }

    // 是否到达输入串末尾
    private boolean end() {
        return index == expr.length();
    }

    // 获取下一个字符，不移动光标
    private char peek() {
        return expr.charAt(index);
    }

    // 获取下一个字符，同时移动光标
    private char next() {
        return expr.charAt(index++);
    }

    // 读取指定字符串，同时移动光标
    private void read(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (end() || next() != token.charAt(i)) {
                throw new RuntimeException("expected " + token);
            }
        }
    }

    // 解析整数
    private int parseInteger() {
        int value = 0;
        while (!end() && Character.isDigit(peek())) {
            value = value * 10 + (next() - '0');
        }
        return value;
    }

    // 解析变量名
    private String parseName() {
        StringBuilder sb = new StringBuilder();
        if (!end() && Character.isAlphabetic(peek())) {
            sb.append(next());
        }
        while (!end() && Character.isLetterOrDigit(peek())) {
            sb.append(next());
        }
        return sb.toString();
    }

    // (add expr expr)
    private int parseAdd(Scope scope) {
        read("add ");
        int lhs = parseExpr(scope);
        read(" ");
        int rhs = parseExpr(scope);
        read(")");
        return lhs + rhs;
    }

    // (mult expr expr)
    private int parseMult(Scope scope) {
        read("mult ");
        int lhs = parseExpr(scope);
        read(" ");
        int rhs = parseExpr(scope);
        read(")");
        return lhs * rhs;
    }

    // (let v1 e1 v2 e2 ... vn en expr)
    private int parseLet(Scope scope) {
        scope = new Scope(scope);
        read("let ");
        while (true) {
            int oldIndex = index;
            try {
                String name = parseName();
                read(" ");
                int value = parseExpr(scope);
                read(" ");
                scope.setVar(name, value);
            } catch (RuntimeException e) {
                index = oldIndex;
                break;
            }
        }
        int r = parseExpr(scope);
        read(")");
        return r;
    }

    // expr = integer
    //      | - integer
    //      | var
    //      | (add expr expr)
    //      | (mult expr expr)
    private int parseExpr(Scope scope) {
        if (Character.isDigit(peek())) {
            return parseInteger();
        } else if (peek() == '-') {
            read("-");
            return -parseInteger();
        } else if (Character.isAlphabetic(peek())) {
            String name = parseName();
            return scope.getVar(name);
        }

        read("(");
        if (peek() == 'a') {
            return parseAdd(scope);
        } else if (peek() == 'm') {
            return parseMult(scope);
        } else if (peek() == 'l') {
            return parseLet(scope);
        }

        throw new RuntimeException("unexpected character " + peek());
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(14, s.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        assertEquals(2, s.evaluate("(let x 3 x 2 x)"));
        assertEquals(5, s.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        assertEquals(4, s.evaluate("(let a1 3 b2 (add a1 1) b2)"));
    }
}
