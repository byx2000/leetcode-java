package byx.leetcode.largest_rectangle_in_histogram;

// https://leetcode.cn/problems/largest-rectangle-in-histogram/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        // left[i]表示heights[i]左边第一个小于heights[i]的元素下标
        int[] left = new int[heights.length];
        left[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j != -1 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        // right[i]表示heights[i]右边第一个小于heights[i]的元素下标
        int[] right = new int[heights.length];
        right[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j != heights.length && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }

        return maxArea;
    }

    @Test
    public void test() {
        assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(4, largestRectangleArea(new int[]{2, 4}));
    }
}
