package byx.leetcode.trapping_rain_water;

// https://leetcode.cn/problems/trapping-rain-water/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int trap(int[] height) {
        // left[i]表示height[0~i]最高元素的高度
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // right[i]表示height[i~len-1]最高元素的高度
        int[] right = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
