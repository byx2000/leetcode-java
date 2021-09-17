package byx.leetcode.problem.有效的括号;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution1 {
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return "".equals(s);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
}
