package byx.leetcode.problem.节点间通路;

/**
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[][] adj = new boolean[n][n];
        for (int[] edge : graph) {
            adj[edge[0]][edge[1]] = true;
        }
        for (int i = 0; i < n; ++i) {
            adj[i][i] = true;
        }

        boolean[] flag = new boolean[n];
        flag[start] = true;

        try {
            dfs(adj, flag, n, target, start);
        } catch (RuntimeException e) {
            return true;
        }

        return false;
    }

    private void dfs(boolean[][] adj, boolean[] flag, int n, int target, int pos) {
        if (pos == target) {
            throw new RuntimeException();
        }

        for (int i = 0; i < n; ++i) {
            if (i != pos && adj[pos][i] && !flag[i]) {
                flag[i] = true;
                dfs(adj, flag, n, target, i);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        System.out.println(solution.findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}
