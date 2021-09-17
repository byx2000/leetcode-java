package byx.leetcode.problem.冗余连接;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = i;
        }

        for (int[] e : edges) {
            int f1 = find(f, e[0]);
            int f2 = find(f, e[1]);
            if (f1 == f2) {
                return e;
            } else {
                f[f2] = f1;
            }
        }

        return new int[]{};
    }

    private int find(int[] f, int i) {
        if (f[i] == i) {
            return i;
        }
        return f[i] = find(f, f[i]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }
}
