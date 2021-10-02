package byx.leetcode.problem.岛屿的最大面积;

/**
 * https://leetcode-cn.com/problems/ZL6zAn/
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                maxArea = Math.max(maxArea, dfs(grid, flag, r, c));
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] flag, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if (grid[r][c] != 1) {
            return 0;
        }

        if (flag[r][c]) {
            return 0;
        }

        flag[r][c] = true;

        return 1 + dfs(grid, flag, r - 1, c) + dfs(grid, flag, r + 1, c) + dfs(grid, flag, r, c - 1) + dfs(grid, flag, r, c + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
    }
}
