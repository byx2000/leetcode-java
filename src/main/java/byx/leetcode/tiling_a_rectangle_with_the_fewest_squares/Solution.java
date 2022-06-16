package byx.leetcode.tiling_a_rectangle_with_the_fewest_squares;

// https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private int n, m;
    private int[][] map;
    private int result;

    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        this.map = new int[n][m];
        this.result = Integer.MAX_VALUE;
        dfs(0);
        return result;
    }

    private void dfs(int cnt) {
        // 剪枝
        if (cnt > result) {
            return;
        }

        // 查找未覆盖的空间
        int r = -1, c = -1;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    r = i;
                    c = j;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        // 所有空间已覆盖，更新结果
        if (!find) {
            result = Math.min(result, cnt);
            return;
        }

        // 尝试放置正方形
        for (int len = Math.min(n - r, m - c); len >= 1; len--) {
            if (canFill(r, c, len)) {
                fill(r, c, len);
                dfs(cnt + 1);
                unFill(r, c, len);
            }
        }
    }

    // 检查位置(r, c)处能否放置边长为len的正方形
    private boolean canFill(int r, int c, int len) {
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void fill(int r, int c, int len) {
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                map[i][j] = 1;
            }
        }
    }

    private void unFill(int r, int c, int len) {
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                map[i][j] = 0;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.tilingRectangle(2, 3));
        assertEquals(5, s.tilingRectangle(5, 8));
        assertEquals(6, s.tilingRectangle(11, 13));
    }
}
