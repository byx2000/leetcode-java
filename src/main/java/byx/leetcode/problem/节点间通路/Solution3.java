package byx.leetcode.problem.节点间通路;

/**
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class Solution3 {
    public boolean findWhetherExistsPath(int n, int[][] edges, int start, int target) {
        boolean[] flag = new boolean[n];
        flag[start] = true;

        try {
            dfs(edges, flag, n, target, start);
        } catch (RuntimeException e) {
            return true;
        }

        return false;
    }

    private void dfs(int[][] edges, boolean[] flag, int n, int target, int pos) {
        if (pos == target) {
            throw new RuntimeException();
        }

        for (int[] e : edges) {
            if (e[0] == pos && !flag[e[1]]) {
                flag[e[1]] = true;
                dfs(edges, flag, n, target, e[1]);
                flag[e[1]] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        System.out.println(solution.findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}
