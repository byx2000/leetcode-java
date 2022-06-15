package byx.leetcode.sqrtx;

// https://leetcode.cn/problems/sqrtx/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.mySqrt(4));
        assertEquals(2, s.mySqrt(8));
    }
}
