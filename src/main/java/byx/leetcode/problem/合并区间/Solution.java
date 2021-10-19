package byx.leetcode.problem.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] > right) {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(right, intervals[i][1]);
            }
        }

        result.add(new int[]{left, right});

        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {4, 5}})));
    }
}
