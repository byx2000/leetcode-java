package byx.leetcode.generate_parentheses;

// https://leetcode.cn/problems/generate-parentheses/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, n, 0, 0, "", result);
        return result;
    }

    // left: 当前左括号数量
    // right: 当前右括号数量
    private void dfs(int step, int n, int left, int right, String s, List<String> result) {
        if (left < right || left > n) {
            return;
        }

        if (step == 2 * n) {
            result.add(s);
            return;
        }

        dfs(step + 1, n, left + 1, right, s + "(", result);
        dfs(step + 1, n, left, right + 1, s + ")", result);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of("()"), new HashSet<>(s.generateParenthesis(1)));
        assertEquals(Set.of("((()))", "(()())", "(())()", "()(())", "()()()"), new HashSet<>(s.generateParenthesis(3)));
    }
}
