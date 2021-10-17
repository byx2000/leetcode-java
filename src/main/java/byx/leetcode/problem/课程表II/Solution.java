package byx.leetcode.problem.课程表II;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class Solution {
    public int[] findOrder(int n, int[][] edges) {
        // 计算邻接表
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            if (adj.containsKey(e[1])) {
                adj.get(e[1]).add(e[0]);
            } else {
                adj.put(e[1], new HashSet<>(Set.of(e[0])));
            }
        }

        // 计算所有节点的入度
        int[] in = new int[n];
        for (int b : adj.keySet()) {
            for (int e : adj.get(b)) {
                in[e]++;
            }
        }

        List<Integer> result = new ArrayList<>();

        // 不断移除入度为0的节点，并更新节点入度
        Queue<Integer> ready = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                ready.add(i);
            }
        }

        while (!ready.isEmpty()) {
            int cnt = ready.size();
            for (int i = 0; i < cnt; ++i) {
                int b = ready.remove();
                result.add(b);
                if (adj.containsKey(b)) {
                    for (int e : adj.get(b)) {
                        in[e]--;
                        if (in[e] == 0) {
                            ready.add(e);
                        }
                    }
                }
            }
        }

        // 检查是否还有未删除的节点
        for (int i : in) {
            if (i > 0) {
                return new int[]{};
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(solution.findOrder(1, new int[][]{})));
    }
}
