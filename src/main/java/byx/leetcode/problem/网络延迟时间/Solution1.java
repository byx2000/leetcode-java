package byx.leetcode.problem.网络延迟时间;

/**
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class Solution1 {
    private static final int INF = 99999;

    public int networkDelayTime(int[][] times, int n, int m) {
        // 构造邻接矩阵
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                adj[i][j] = (i == j) ? 0 : INF;
            }
        }
        for (int[] edge : times) {
            adj[edge[0]][edge[1]] = edge[2];
        }

        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        int time = -1;
        for (int i = 1; i <= n; ++i) {
            time = Math.max(time, adj[m][i]);
        }

        return time >= INF ? -1 : time;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
