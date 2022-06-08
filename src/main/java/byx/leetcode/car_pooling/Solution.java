package byx.leetcode.car_pooling;

// https://leetcode.cn/problems/car-pooling/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] t : trips) {
            diff[t[1]] += t[0];
            diff[t[2]] -= t[0];
        }

        int sum = 0;
        for (int d : diff) {
            sum += d;
            if (sum > capacity) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.carPooling(new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        }, 4));
        assertTrue(s.carPooling(new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        }, 5));
    }
}
