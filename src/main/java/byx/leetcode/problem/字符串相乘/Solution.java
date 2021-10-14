package byx.leetcode.problem.字符串相乘;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        List<String> adder = new ArrayList<>();
        String zero = "";

        for (int i = 0; i < num2.length(); ++i) {
            adder.add(zero + multiply(num1, num2.charAt(i)));
            zero += 0;
        }

        String result = "0";
        for (String s : adder) {
            result = add(result, s);
        }
        result = new StringBuilder(result).reverse().toString();

        // 去除前导0
        while (result.length() > 0 && result.startsWith("0")) {
            result = result.substring(1);
        }
        if ("".equals(result)) {
            result = "0";
        }

        return result;
    }

    private int toDigit(char c) {
        return c - '0';
    }

    private String multiply(String num, char d) {
        String result = "";
        int carry = 0;

        for (int i = 0; i < num.length(); ++i) {
            int sum = toDigit(num.charAt(i)) * toDigit(d) + carry;
            result += sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            result += carry;
        }

        return result;
    }

    private String add(String num1, String num2) {
        String result = "";
        int carry = 0;

        int i = 0, j = 0;
        while (i < num1.length() || j < num2.length()) {
            int sum = carry;
            if (i < num1.length()) {
                sum += toDigit(num1.charAt(i));
                i++;
            }
            if (j < num2.length()) {
                sum += toDigit(num2.charAt(j));
                j++;
            }

            result += sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            result += carry;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("123", "456"));
    }
}
