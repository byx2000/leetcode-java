package byx.leetcode.problem.有效的括号字符串;

/**
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 */
public class Solution {
    public boolean checkValidString(String s) {
        int minCnt = 0, maxCnt = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                minCnt++;
                maxCnt++;
            } else if (c == ')') {
                minCnt = Math.max(0, minCnt - 1);
                maxCnt--;
                if (maxCnt < 0) {
                    return false;
                }
            } else {
                minCnt = Math.max(0, minCnt - 1);
                maxCnt++;
            }
        }

        return minCnt == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString("()"));
        System.out.println(solution.checkValidString("(*)"));
        System.out.println(solution.checkValidString("(*))"));
    }
}
