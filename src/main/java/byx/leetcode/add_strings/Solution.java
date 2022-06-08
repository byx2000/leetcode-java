package byx.leetcode.add_strings;

// https://leetcode.cn/problems/add-strings/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public String addStrings(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

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

        return result.reverse().toString();
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("134", s.addStrings("11", "123"));
        assertEquals("533", s.addStrings("456", "77"));
        assertEquals("0", s.addStrings("0", "0"));
        assertEquals("10", s.addStrings("1", "9"));
    }
}
