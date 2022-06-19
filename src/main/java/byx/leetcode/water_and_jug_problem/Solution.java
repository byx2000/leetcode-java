package byx.leetcode.water_and_jug_problem;

// https://leetcode.cn/problems/water-and-jug-problem/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean canMeasureWater(int a, int b, int target) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0, 0));
        Set<List<Integer>> visited = new HashSet<>();
        visited.add(List.of(0, 0));

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.remove();

            // 达到目标状态
            if (cur.get(0) == target || cur.get(1) == target || cur.get(0) + cur.get(1) == target) {
                return true;
            }

            // 加满第一个水壶
            if (cur.get(0) < a) {
                List<Integer> next = List.of(a, cur.get(1));
                addNext(queue, visited, next);
            }

            // 加满第二个水壶
            if (cur.get(1) < b) {
                List<Integer> next = List.of(cur.get(0), b);
                addNext(queue, visited, next);
            }

            // 倒空第一个水壶
            if (cur.get(0) > 0) {
                List<Integer> next = List.of(0, cur.get(1));
                addNext(queue, visited, next);
            }

            // 倒空第二个水壶
            if (cur.get(1) > 0) {
                List<Integer> next = List.of(cur.get(0), 0);
                addNext(queue, visited, next);
            }

            // 第一个水壶倒入第二个水壶
            if (cur.get(0) > 0) {
                int left = b - cur.get(1);
                List<Integer> next;
                if (cur.get(0) <= left) {
                    next = List.of(0, cur.get(1) + cur.get(0));
                } else {
                    next = List.of(cur.get(0) - left, b);
                }
                addNext(queue, visited, next);
            }

            // 第二个水壶倒入第一个水壶
            if (cur.get(1) > 0) {
                int left = a - cur.get(0);
                List<Integer> next;
                if (cur.get(1) <= left) {
                    next = List.of(cur.get(1) + cur.get(0), 0);
                } else {
                    next = List.of(a, cur.get(1) - left);
                }
                addNext(queue, visited, next);
            }
        }

        return false;
    }

    private void addNext(Queue<List<Integer>> queue, Set<List<Integer>> visited, List<Integer> next) {
        if (!visited.contains(next)) {
            visited.add(next);
            queue.add(next);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canMeasureWater(3, 5, 4));
        assertFalse(s.canMeasureWater(2, 6, 5));
        assertTrue(s.canMeasureWater(1, 2, 3));
    }
}
