package byx.leetcode.problem.课程表;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class Solution {
    public boolean canFinish(int n, int[][] edges) {
        // 计算邻接表
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            if (adj.containsKey(e[0])) {
                adj.get(e[0]).add(e[1]);
            } else {
                adj.put(e[0], new HashSet<>(Set.of(e[1])));
            }
        }

        // 计算所有节点的入度
        int[] in = new int[n];
        for (int b : adj.keySet()) {
            for (int e : adj.get(b)) {
                in[e]++;
            }
        }

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
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canFinish(4, new int[][]{{0, 1}, {1, 2}, {1, 3}}));
        System.out.println(solution.canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 0}, {3, 1}}));
    }
}
