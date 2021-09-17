package byx.leetcode.problem.飞地的数量;

/**
 * https://leetcode-cn.com/problems/number-of-enclaves/
 */
public class Solution {
    public int numEnclaves(int[][] grid) {
        for (int r = 0; r < grid.length; ++r) {
            dfs(grid, r, 0);
            dfs(grid, r, grid[r].length - 1);
        }

        for (int c = 0; c < grid[0].length; ++c) {
            dfs(grid, 0, c);
            dfs(grid, grid.length - 1, c);
        }

        int cnt = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                if (grid[r][c] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) {
            return;
        }

        if (grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 0;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        }));
        System.out.println(solution.numEnclaves(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        }));
    }
}
