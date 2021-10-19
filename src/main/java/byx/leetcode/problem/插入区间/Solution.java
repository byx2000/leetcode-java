package byx.leetcode.problem.插入区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean flag = false;

        for (int[] i : intervals) {
            if (i[1] < newInterval[0]) {
                result.add(i);
            } else if (i[0] > newInterval[1]) {
                if (!flag) {
                    result.add(newInterval);
                    flag = true;
                }
                result.add(i);
            } else {
                newInterval = new int[]{Math.min(newInterval[0], i[0]), Math.max(newInterval[1], i[1])};
            }
        }

        if (!flag) {
            result.add(newInterval);
        }

        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{}, new int[]{5, 7})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 5}}, new int[]{2, 3})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 5}}, new int[]{2, 7})));
    }
}
