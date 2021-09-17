package byx.leetcode.problem.规定时间内到达终点的最小花费;

/**
 * https://leetcode-cn.com/problems/minimum-cost-to-reach-destination-in-time/
 */
public class Solution {
    private static final int INF = 99999;

    private int n;
    private int[][] adj;
    private int[] passingFees;
    private int maxTime;
    private Integer[][] cache;

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        n = passingFees.length;
        this.passingFees = passingFees;
        this.maxTime = maxTime;

        // 构造邻接矩阵
        adj = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                adj[i][j] = INF;
            }
        }
        for (int[] e : edges) {
            adj[e[0]][e[1]] = adj[e[1]][e[0]] = e[2];
        }

        cache = new Integer[n][1001];
        int minFee = dfs(0, 0);

        return (minFee >= INF) ? -1 : minFee;
    }

    private int dfs(int pos, int time) {
        if (time > maxTime) {
            return INF;
        }

        if (cache[pos][time] != null) {
            return cache[pos][time];
        }

        if (pos == n - 1) {
            return cache[pos][time] = passingFees[n - 1];
        }

        int minFee = INF;
        for (int i = 0; i < n; ++i) {
            if (adj[pos][i] != INF) {
                //minFee = Math.min(minFee, dfs(i, time + adj[pos][i]) + passingFees[pos]);
                int fee = dfs(i, time + adj[pos][i]);
                if (fee != INF) {
                    minFee = Math.min(minFee, fee + passingFees[pos]);
                }
            }
        }

        return cache[pos][time] = minFee;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(
                30,
                new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}},
                new int[]{5, 1, 2, 20, 20, 3}
        ));
        System.out.println(solution.minCost(
                29,
                new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}},
                new int[]{5, 1, 2, 20, 20, 3}
        ));
        System.out.println(solution.minCost(
                25,
                new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}},
                new int[]{5, 1, 2, 20, 20, 3}
        ));
    }
}
