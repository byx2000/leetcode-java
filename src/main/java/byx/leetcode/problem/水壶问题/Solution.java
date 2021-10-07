package byx.leetcode.problem.水壶问题;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();

        // 初始状态
        addState(queue, set, x, 0);
        addState(queue, set, 0, y);

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.remove();
            int a = cur.get(0);
            int b = cur.get(1);

            if (a == z || b == z || a + b == z) {
                return true;
            }

            // 清空第一个水壶
            if (a > 0) {
                addState(queue, set, 0, b);
            }

            // 清空第二个水壶
            if (b > 0) {
                addState(queue, set, a, 0);
            }

            // 装满第一个水壶
            if (a < x) {
                addState(queue, set, x, b);
            }

            // 装满第二个水壶
            if (b < y) {
                addState(queue, set, a, y);
            }

            // 第一个水壶向第二个水壶倒水
            if (a > 0 && b < y) {
                if (a + b <= y) {
                    addState(queue, set, 0, a + b);
                } else {
                    addState(queue, set, a - (y - b), y);
                }
            }

            // 第二个水壶向第一个水壶倒水
            if (b > 0 && a < x) {
                if (a + b <= x) {
                    addState(queue, set, a + b, 0);
                } else {
                    addState(queue, set, x, b - (x - a));
                }
            }
        }

        return false;
    }

    // 添加状态
    private void addState(Queue<List<Integer>> queue, Set<List<Integer>> set, int x, int y) {
        List<Integer> state = List.of(x, y);
        if (!set.contains(state)) {
            set.add(state);
            queue.add(state);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(2, 6, 5));
        System.out.println(solution.canMeasureWater(1, 2, 3));
    }
}
