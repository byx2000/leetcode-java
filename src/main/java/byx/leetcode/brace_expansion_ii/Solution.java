package byx.leetcode.brace_expansion_ii;

// https://leetcode.cn/problems/brace-expansion-ii/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String expr;
    private int index;

    public List<String> braceExpansionII(String expr) {
        this.expr = expr;
        this.index = 0;
        ArrayList<String> list = new ArrayList<>(parseExpr());
        list.sort(String::compareTo);
        return list;
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

    // term = alphabet | { expr (, expr)* }
    private Set<String> parseTerm() {
        char c = peek();
        if (Character.isAlphabetic(c)) {
            return Set.of(String.valueOf(next()));
        } else if (c == '{') {
            next(); // 读取'{'
            Set<String> r = new HashSet<>(parseExpr());
            while (peek() == ',') {
                next(); // 读取','
                r.addAll(parseExpr());
            }
            next(); // 读取'}'
            return r;
        }
        throw new RuntimeException("unexpected character: " + c);
    }

    // expr = term*
    private Set<String> parseExpr() {
        Set<String> r = parseTerm();
        while (!end() && peek() != ',' && peek() != '}') {
            r = cross(r, parseTerm());
        }
        return r;
    }

    // 求两个集合的笛卡尔积
    private Set<String> cross(Set<String> s1, Set<String> s2) {
        Set<String> s = new HashSet<>();
        for (String a : s1) {
            for (String b : s2) {
                s.add(a + b);
            }
        }
        return s;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(List.of("ac", "ad", "ae", "bc", "bd", "be"), s.braceExpansionII("{a,b}{c,{d,e}}"));
        assertEquals(List.of("a", "ab", "ac", "z"), s.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
}
