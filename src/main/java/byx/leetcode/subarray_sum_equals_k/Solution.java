package byx.leetcode.subarray_sum_equals_k;

// https://leetcode.cn/problems/subarray-sum-equals-k/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0;
        int cnt = 0;

        for (int n : nums) {
            sum += n;
            cnt += m.getOrDefault(sum - k, 0);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, s.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
