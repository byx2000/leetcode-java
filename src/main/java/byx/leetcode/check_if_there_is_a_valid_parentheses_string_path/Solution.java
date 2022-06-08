package byx.leetcode.check_if_there_is_a_valid_parentheses_string_path;

// https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean hasValidPath(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if ((row + col - 1) % 2 != 0) {
            return false;
        }

        Boolean[][][] cache = new Boolean[row][col][row + col];
        return dfs(grid, cache, 0, 0, 0);
    }

    // r: 当前所在行
    // c: 当前所在列
    // left: 当前左括号数量
    // right: 当前右括号数量
    private boolean dfs(char[][] grid, Boolean[][][] cache, int r, int c, int left) {
        // 越界
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) {
            return false;
        }

        if (cache[r][c][left] != null) {
            return cache[r][c][left];
        }

        // 左括号数量超过一半
        if (left > (grid.length + grid[r].length - 1) / 2) {
            return cache[r][c][left] = false;
        }

        // 计算当前右括号数量
        int right = r + c - left;

        // 左括号数量小于右括号数量
        if (left < right) {
            return cache[r][c][left] = false;
        }

        // 到达终点
        if (r == grid.length - 1 && c == grid[r].length - 1) {
            return cache[r][c][left] = grid[r][c] == ')' && left == right + 1;
        }

        boolean ret;
        if (grid[r][c] == '(') {
            ret = dfs(grid, cache, r + 1, c, left + 1) || dfs(grid, cache, r, c + 1, left + 1);
        } else {
            ret = dfs(grid, cache, r + 1, c, left) || dfs(grid, cache, r, c + 1, left);
        }

        return cache[r][c][left] = ret;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.hasValidPath(new char[][]{
                {'(', '(', '('},
                {')', '(', ')'},
                {'(', '(', ')'},
                {'(', '(', ')'}
        }));
        assertFalse(s.hasValidPath(new char[][]{
                {')', ')'},
                {'(', '('}
        }));
        assertFalse(s.hasValidPath(new char[][]{
                {'(', ')'},
                {'(', ')'}
        }));
        assertFalse(s.hasValidPath(new char[][]{
                {'(', '(', ')', '(', '(', ')', '(', ')', '('},
                {')', '(', '(', '(', ')', ')', ')', '(', '('},
                {'(', ')', ')', '(', '(', ')', '(', '(', '('},
                {'(', '(', ')', '(', ')', '(', '(', ')', '('},
                {'(', ')', '(', ')', ')', ')', '(', ')', ')'}
        }));
        assertFalse(s.hasValidPath(new char[][]{
                {'(', '(', ')', ')', ')', '(', '(', ')', '(', '(', ')', '(', ')', '(', '(', ')'},
                {')', '(', ')', ')', ')', ')', '(', '(', '(', '(', ')', ')', '(', '(', '(', '('},
                {'(', ')', ')', ')', '(', '(', '(', ')', '(', '(', ')', ')', ')', '(', ')', ')'},
                {'(', '(', ')', ')', ')', ')', '(', '(', '(', ')', '(', '(', '(', ')', '(', '('},
                {'(', '(', '(', '(', '(', '(', ')', ')', ')', '(', '(', ')', ')', '(', ')', ')'},
                {'(', '(', ')', '(', ')', '(', '(', '(', '(', ')', ')', ')', '(', '(', ')', ')'},
                {')', '(', '(', '(', ')', '(', ')', ')', ')', ')', '(', '(', ')', ')', ')', '('},
                {'(', '(', '(', ')', '(', '(', ')', ')', ')', '(', '(', ')', '(', ')', ')', '('},
                {')', ')', '(', ')', ')', ')', '(', '(', '(', ')', '(', '(', ')', '(', ')', ')'},
                {'(', '(', ')', ')', ')', '(', ')', ')', ')', ')', '(', ')', '(', '(', '(', ')'},
                {'(', '(', '(', ')', '(', ')', ')', '(', '(', ')', ')', ')', '(', ')', '(', ')'},
                {'(', ')', ')', ')', ')', ')', ')', '(', ')', ')', ')', ')', '(', ')', ')', ')'},
                {')', '(', ')', ')', '(', '(', '(', '(', '(', ')', '(', ')', '(', ')', '(', ')'},
                {')', ')', ')', ')', '(', ')', ')', '(', ')', ')', ')', ')', '(', '(', ')', ')'}
        }));
    }
}
