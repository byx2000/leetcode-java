package byx.leetcode.remove_invalid_parentheses;

// https://leetcode.cn/problems/remove-invalid-parentheses/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String s;
    private Set<String> result;
    private int maxLen;
    private int left;
    private int right;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.result = new HashSet<>();
        this.maxLen = 0;
        this.left = 0;
        this.right = 0;
        dfs(0, "");
        return new ArrayList<>(result);
    }

    private void dfs(int index, String cur) {
        if (index == s.length()) {
            if (left == right && cur.length() >= maxLen) {
                if (cur.length() > maxLen) {
                    maxLen = cur.length();
                    result.clear();
                }
                result.add(cur);
            }
            return;
        }

        if (left < right) {
            return;
        }

        char c = s.charAt(index);
        if (c == '(') {
            dfs(index + 1, cur);
            left++;
            dfs(index + 1, cur + '(');
            left--;
        } else if (c == ')') {
            dfs(index + 1, cur);
            right++;
            dfs(index + 1, cur + ')');
            right--;
        } else {
            dfs(index + 1, cur + c);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of("(())()", "()()()"), new HashSet<>(s.removeInvalidParentheses("()())()")));
        assertEquals(Set.of("(a())()", "(a)()()"), new HashSet<>(s.removeInvalidParentheses("(a)())()")));
        assertEquals(Set.of(""), new HashSet<>(s.removeInvalidParentheses(")(")));
    }
}
