package byx.leetcode.problem.节点间通路;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class Solution4 {
    public boolean findWhetherExistsPath(int n, int[][] edges, int start, int target) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            if (adj.containsKey(e[0])) {
                adj.get(e[0]).add(e[1]);
            } else {
                adj.put(e[0], new HashSet<>(Set.of(e[1])));
            }
        }

        boolean[] flag = new boolean[n];
        flag[start] = true;

        return dfs(adj, flag, n, target, start);
    }

    private boolean dfs(Map<Integer, Set<Integer>> adj, boolean[] flag, int n, int target, int pos) {
        if (pos == target) {
            return true;
        }

        if (!adj.containsKey(pos)) {
            return false;
        }

        for (int i : adj.get(pos)) {
            if (!flag[i]) {
                flag[i] = true;
                boolean result = dfs(adj, flag, n, target, i);
                flag[i] = false;
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        System.out.println(solution.findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}
