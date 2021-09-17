package byx.leetcode.problem.字符串相乘;

/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int sum = charToInt(num1.charAt(i)) + charToInt(num2.charAt(j)) + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = charToInt(num1.charAt(i)) + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
        }

        while (j >= 0) {
            int sum = charToInt(num2.charAt(j)) + carry;
            result.append(sum % 10);
            carry = sum / 10;
            j--;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private int charToInt(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("11", "123"));
        System.out.println(solution.addStrings("456", "77"));
        System.out.println(solution.addStrings("0", "0"));
    }
}
