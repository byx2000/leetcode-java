package byx.leetcode.subarray_sums_divisible_by_k;

// https://leetcode.cn/problems/subarray-sums-divisible-by-k/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0;
        int cnt = 0;

        for (int n : nums) {
            sum += n;
            int r = (sum % k + k) % k;
            cnt += m.getOrDefault(r, 0);
            m.put(r, m.getOrDefault(r, 0) + 1);
        }

        return cnt;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        assertEquals(0, s.subarraysDivByK(new int[]{5}, 9));
        assertEquals(2, s.subarraysDivByK(new int[]{-1, 2, 9}, 2));
    }
}
