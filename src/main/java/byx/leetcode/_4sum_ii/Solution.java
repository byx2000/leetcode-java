package byx.leetcode._4sum_ii;

// https://leetcode.cn/problems/4sum-ii/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }

        int result = 0;
        for (int a : nums3) {
            for (int b : nums4) {
                result += cnt.getOrDefault(-(a + b), 0);
            }
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        assertEquals(1, s.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
    }
}
