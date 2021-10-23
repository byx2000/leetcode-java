package byx.leetcode.problem.不含AAA或BBB的字符串;

/**
 * https://leetcode-cn.com/problems/string-without-aaa-or-bbb/
 */
public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            if (a == 0) {
                result.append("b");
                b--;
            } else if (b == 0) {
                result.append("a");
                a--;
            } else if (a > b) {
                result.append("aab");
                a -= 2;
                b -= 1;
            } else if (a < b) {
                result.append("bba");
                a -= 1;
                b -= 2;
            } else {
                result.append("ab");
                a -= 1;
                b -= 1;
            }
        }

        return result.toString();
    }
}
