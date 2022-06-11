package byx.leetcode.insert_interval;

// https://leetcode.cn/problems/insert-interval/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        boolean flag = false;
        for (int[] span : intervals) {
            if (span[1] < newInterval[0]) {
                result.add(span);
            } else if (span[0] > newInterval[1]) {
                if (!flag) {
                    flag = true;
                    result.add(newInterval);
                }
                result.add(span);
            } else {
                newInterval = new int[]{Math.min(span[0], newInterval[0]), Math.max(span[1], newInterval[1])};
            }
        }

        if (!flag) {
            result.add(newInterval);
        }

        return result.toArray(int[][]::new);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[][]{{1, 5}, {6, 9}}, s.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
        assertArrayEquals(new int[][]{{1, 2}, {3, 10}, {12, 16}}, s.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}));
        assertArrayEquals(new int[][]{{5, 7}}, s.insert(new int[][]{}, new int[]{5, 7}));
        assertArrayEquals(new int[][]{{1, 5}}, s.insert(new int[][]{{1, 5}}, new int[]{2, 3}));
        assertArrayEquals(new int[][]{{1, 7}}, s.insert(new int[][]{{1, 5}}, new int[]{2, 7}));
    }
}
