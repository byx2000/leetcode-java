package byx.leetcode.multiply_strings;

// https://leetcode.cn/problems/multiply-strings/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        StringBuilder preZero = new StringBuilder();
        String result = "0";

        for (int i = 0; i < num2.length(); i++) {
            String r = mul(num1, num2.charAt(i) - '0');
            r = preZero + r;
            result = add(result, r);
            preZero.append("0");
        }

        result = new StringBuilder(result).reverse().toString();

        while (result.length() > 0 && result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return result.length() == 0 ? "0" : result;
    }

    // 计算num1 + num2（num1、num2和结果都是倒序）
    private String add(String num1, String num2) {
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int r = carry;
            if (i < num1.length()) {
                r += num1.charAt(i) - '0';
            }
            if (i < num2.length()) {
                r += num2.charAt(i) - '0';
            }
            result.append(r % 10);
            carry = r / 10;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.toString();
    }

    // 计算num * n（num和结果都是倒序）
    private String mul(String num, int n) {
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            int r = n * (num.charAt(i) - '0') + carry;
            result.append(r % 10);
            carry = r / 10;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.toString();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("6", s.multiply("2", "3"));
        assertEquals("56088", s.multiply("123", "456"));
        assertEquals("81", s.multiply("9", "9"));
        assertEquals("0", s.multiply("9133", "0"));
    }
}
