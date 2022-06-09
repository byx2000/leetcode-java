package byx.leetcode.corporate_flight_bookings;

// https://leetcode.cn/problems/corporate-flight-bookings/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int[] b : bookings) {
            diff[b[0]] += b[2];
            if (b[1] < n) {
                diff[b[1] + 1] -= b[2];
            }
        }

        int[] seat = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i + 1];
            seat[i] = sum;
        }

        return seat;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{10, 55, 45, 25, 25}, s.corpFlightBookings(new int[][]{
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        }, 5));
        assertArrayEquals(new int[]{10, 25}, s.corpFlightBookings(new int[][]{
                {1, 2, 10},
                {2, 2, 15}
        }, 2));
    }
}
