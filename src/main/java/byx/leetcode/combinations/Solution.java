package byx.leetcode.combinations;

// https://leetcode.cn/problems/combinations/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[n + 1];
        dfs(1, k, flag, new LinkedList<>(), result);
        return result;
    }

    public void dfs(int cur, int step, boolean[] flag, LinkedList<Integer> path, List<List<Integer>> result) {
        if (step == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur; i < flag.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                path.add(i);
                dfs(i, step - 1, flag, path, result);
                path.removeLast();
                flag[i] = false;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of(1)
        ), new HashSet<>(s.combine(1, 1)));
        assertEquals(Set.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 3),
                List.of(2, 4),
                List.of(3, 4)
        ), new HashSet<>(s.combine(4, 2)));
    }
}
