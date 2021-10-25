package byx.leetcode.problem.颜色填充;

/**
 * https://leetcode-cn.com/problems/color-fill-lcci/
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, image[sr][sc], newColor, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int oldColor, int newColor, int r, int c) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[r].length) {
            return;
        }

        if (image[r][c] != oldColor || image[r][c] == newColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, oldColor, newColor, r - 1, c);
        dfs(image, oldColor, newColor, r + 1, c);
        dfs(image, oldColor, newColor, r, c - 1);
        dfs(image, oldColor, newColor, r, c + 1);
    }
}
