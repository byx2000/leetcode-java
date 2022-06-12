package byx.leetcode.maximum_width_ramp;

// https://leetcode.cn/problems/maximum-width-ramp/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int maxWidthRamp(int[] nums) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[]{i, nums[i]};
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        int maxLen = 0;
        int minVal = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            minVal = Math.min(minVal, arr[i][0]);
            maxLen = Math.max(maxLen, arr[i][0] - minVal);
        }

        return maxLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        assertEquals(7, s.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }
}
