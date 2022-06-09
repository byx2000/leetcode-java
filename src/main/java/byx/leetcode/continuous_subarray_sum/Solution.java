package byx.leetcode.continuous_subarray_sum;

// https://leetcode.cn/problems/continuous-subarray-sum/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (m.containsKey(sum % k)) {
                if (i - m.get(sum % k) >= 2) {
                    return true;
                }
            } else {
                m.put(sum % k, i);
            }
        }

        return false;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        assertTrue(s.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        assertFalse(s.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        assertTrue(s.checkSubarraySum(new int[]{2, 4, 3}, 6));
        assertFalse(s.checkSubarraySum(new int[]{1, 0}, 2));
    }
}
