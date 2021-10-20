package byx.leetcode.problem.冗余连接;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] f = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; ++i) {
            f[i] = i;
        }

        for (int[] e : edges) {
            if (find(f, e[0]) == find(f, e[1])) {
                return e;
            } else {
                merge(f, e[0], e[1]);
            }
        }

        throw new RuntimeException();
    }

    private void merge(int[] f, int m, int n) {
        f[find(f, m)] = n;
    }

    private int find(int[] f, int n) {
        if (f[n] == n) {
            return n;
        }
        return f[n] = find(f, f[n]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }
}
