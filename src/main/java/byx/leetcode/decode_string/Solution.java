package byx.leetcode.decode_string;

// https://leetcode.cn/problems/decode-string/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String s;
    private int index;

    public String decodeString(String s) {
        this.s = s;
        this.index = 0;
        return parseExpr();
    }

    // 是否到达输入串末尾
    private boolean end() {
        return index == s.length();
    }

    // 获取下一个字符
    private char peek() {
        return s.charAt(index);
    }

    // 获取下一个字符，并向前移动一个字符
    private char next() {
        return s.charAt(index++);
    }

    private String parseAlpha() {
        return String.valueOf(next());
    }

    private int parseNum() {
        int r = 0;
        while (Character.isDigit(peek())) {
            r = r * 10 + (next() - '0');
        }
        return r;
    }

    private String parseRepeat() {
        int cnt = parseNum();
        next(); // 读取'['
        String r = parseExpr().repeat(cnt);
        next(); // 读取']'
        return r;
    }

    private String parseExpr() {
        StringBuilder sb = new StringBuilder();
        while (!end() && peek() != ']') {
            char c = peek();
            if (Character.isAlphabetic(c)) {
                sb.append(parseAlpha());
            } else if (Character.isDigit(c)) {
                sb.append(parseRepeat());
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("aaabcbc", s.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", s.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", s.decodeString("2[abc]3[cd]ef"));
    }
}
