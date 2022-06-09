package byx.leetcode.count_number_of_nice_subarrays;

// https://leetcode.cn/problems/count-number-of-nice-subarrays/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int cOdd = 0;
        int result = 0;

        for (int n : nums) {
            if (n % 2 == 1) {
                cOdd++;
            }
            result += m.getOrDefault(cOdd - k, 0);
            m.put(cOdd, m.getOrDefault(cOdd, 0) + 1);
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        assertEquals(0, s.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        assertEquals(16, s.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
