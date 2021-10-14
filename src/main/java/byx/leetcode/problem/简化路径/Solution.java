package byx.leetcode.problem.简化路径;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if ("".equals(s)) {
                continue;
            }

            if (".".equals(s)) {
                continue;
            }

            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        String result = "";
        for (String s : new ArrayList<>(stack)) {
            result += ("/" + s);
        }

        if ("".equals(result)) {
            result = "/";
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }
}
