package byx.leetcode.problem.K站中转内最便宜的航班;

/**
 * https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
 */
public class Solution {
    private static final int INF = 99999;
    private int[][] adj;
    private int n;
    private int maxJump;
    private int dst;
    private Integer[][] cache;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 构造邻接矩阵
        adj = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                adj[i][j] = (i == j) ? 0 : INF;
            }
        }
        for (int[] edge : flights) {
            adj[edge[0]][edge[1]] = edge[2];
        }

        maxJump = k;
        this.dst = dst;
        this.n = n;
        cache = new Integer[n][n];

        int minPrice = dfs(src, 0);

        return minPrice >= INF ? -1 : minPrice;
    }

    private int dfs(int pos, int jump) {
        if (jump > maxJump) {
            return INF;
        }

        if (cache[pos][jump] != null) {
            return cache[pos][jump];
        }

        if (pos == dst) {
            return cache[pos][jump] = 0;
        }

        int minPrice = INF;
        for (int i = 0; i < n; ++i) {
            if (adj[pos][i] != INF) {
                minPrice = Math.min(minPrice, adj[pos][i] + dfs(i, i == dst ? jump : jump + 1));
            }
        }

        return cache[pos][jump] = minPrice;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }
}
