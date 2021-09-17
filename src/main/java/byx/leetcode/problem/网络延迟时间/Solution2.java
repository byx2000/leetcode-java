package byx.leetcode.problem.网络延迟时间;

/**
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class Solution2 {
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

        int[] dis = new int[n + 1];
        boolean[] flag = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            dis[i] = adj[m][i];
        }

        while (true) {
            int minDis = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 1; i <= n; ++i) {
                if (!flag[i]) {
                    if (dis[i] < minDis) {
                        minDis = dis[i];
                        minIndex = i;
                    }
                }
            }

            if (minIndex == -1) {
                break;
            }

            flag[minIndex] = true;
            for (int i = 1; i <= n; ++i) {
                if (i != minIndex) {
                    if (dis[i] > dis[minIndex] + adj[minIndex][i]) {
                        dis[i] = dis[minIndex] + adj[minIndex][i];
                    }
                }
            }
        }

        int time = -1;
        for (int i = 1; i <= n; ++i) {
            time = Math.max(time, dis[i]);
        }

        return time >= INF ? -1 : time;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
