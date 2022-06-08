package byx.leetcode.contiguous_array;

// https://leetcode.cn/problems/contiguous-array/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int findMaxLength(int[] nums) {
        // 将nums中的0变成-1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        // 求和为0的连续子数组最大长度
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (m.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - m.get(sum));
            } else {
                m.put(sum, i);
            }
        }

        return maxLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findMaxLength(new int[]{0, 1}));
        assertEquals(2, s.findMaxLength(new int[]{0, 1, 0}));
    }
}
