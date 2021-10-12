package byx.leetcode.problem.字符串转换整数;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Solution {
    public int myAtoi(String s) {
        int i = 0;
        long result = 0;
        int sign = 1;

        // 处理前导空格
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // 处理正负号
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
        }
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        // 累加
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            int d = s.charAt(i) - '0';
            result = result * 10 + d;

            // 处理溢出
            if (sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("834683698364965398"));
        System.out.println(solution.myAtoi(""));
        System.out.println(solution.myAtoi(" "));
    }
}
