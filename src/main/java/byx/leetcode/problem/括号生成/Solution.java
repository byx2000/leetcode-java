package byx.leetcode.problem.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", 0, 0, n, result);
        return result;
    }

    private void dfs(String s, int cLeft, int cRight, int n, List<String> result) {
        if (cLeft > n || cRight > n) {
            return;
        }

        if (cLeft < cRight) {
            return;
        }

        if (cLeft == n && cRight == n) {
            result.add(s);
            return;
        }

        dfs(s + "(", cLeft + 1, cRight, n, result);
        dfs(s + ")", cLeft, cRight + 1, n, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(4));
    }
}
