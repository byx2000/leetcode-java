package byx.leetcode.problem.节点间通路;

/**
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class Solution2 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }

        for (int[] edge : graph) {
            if (edge[1] == target) {
                boolean result = findWhetherExistsPath(n, graph, start, edge[0]);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        System.out.println(solution.findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}
