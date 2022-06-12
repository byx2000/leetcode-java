package byx.leetcode.merge_intervals;

// https://leetcode.cn/problems/merge-intervals/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(int[][]::new);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        assertArrayEquals(new int[][]{{1, 5}}, s.merge(new int[][]{{1, 4}, {4, 5}}));
        assertArrayEquals(new int[][]{{1, 4}, {5, 6}}, s.merge(new int[][]{{1, 4}, {5, 6}}));
        assertArrayEquals(new int[][]{{0, 0}, {1, 4}}, s.merge(new int[][]{{1, 4}, {0, 0}}));
    }
}
