package byx.leetcode.coloring_a_border;

// https://leetcode.cn/problems/coloring-a-border/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    private int[][] grid;
    private boolean[][] flag;
    private int oldColor;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        this.oldColor = grid[row][col];

        this.flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            flag[i] = new boolean[grid[i].length];
        }

        dfs(row, col);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (flag[r][c]) {
                    // 如果当前位置是边界则染色
                    if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[r].length - 1
                            || !flag[r - 1][c] || !flag[r + 1][c] || !flag[r][c - 1] || !flag[r][c + 1]) {
                        grid[r][c] = color;
                    }
                }
            }
        }

        return grid;
    }

    // 标记当前连通块
    private void dfs(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] != oldColor || flag[r][c]) {
            return;
        }

        flag[r][c] = true;

        dfs(r - 1, c);
        dfs(r + 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][]{
                {3, 3},
                {3, 2}
        }, s.colorBorder(new int[][]{
                {1, 1},
                {1, 2}
        }, 0, 0, 3));
        assertArrayEquals(new int[][]{
                {1, 3, 3},
                {2, 3, 3}
        }, s.colorBorder(new int[][]{
                {1, 2, 2},
                {2, 3, 2}
        }, 0, 1, 3));
        assertArrayEquals(new int[][]{
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        }, s.colorBorder(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }, 1, 1, 2));
        assertArrayEquals(new int[][]{
                {1, 1, 1, 1, 1, 2},
                {1, 2, 1, 1, 1, 2},
                {1, 1, 1, 1, 1, 2}
        }, s.colorBorder(new int[][]{
                {1, 2, 1, 2, 1, 2},
                {2, 2, 2, 2, 1, 2},
                {1, 2, 2, 2, 1, 2}
        }, 1, 3, 1));
    }
}
