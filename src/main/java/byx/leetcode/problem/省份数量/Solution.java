package byx.leetcode.problem.省份数量;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    int f1 = find(f, i);
                    int f2 = find(f, j);
                    if (f1 != f2) {
                        merge(f, f1, f2);
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (find(f, i) == i) {
                cnt++;
            }
        }

        return cnt;
    }

    private int find(int[] f, int i) {
        if (f[i] == i) {
            return i;
        }
        return f[i] = find(f, f[i]);
    }

    private void merge(int[] f, int i, int j) {
        f[i] = j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
