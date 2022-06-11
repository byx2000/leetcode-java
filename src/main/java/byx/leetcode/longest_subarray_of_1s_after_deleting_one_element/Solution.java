package byx.leetcode.longest_subarray_of_1s_after_deleting_one_element;

// https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int cZero = 0;
        int maxLen = 0;

        while (j < nums.length) {
            while (j < nums.length && cZero <= 1) {
                maxLen = Math.max(maxLen, j - i - 1);
                if (nums[j] == 0) {
                    cZero++;
                }
                j++;
            }

            if (j == nums.length && cZero <= 1) {
                maxLen = Math.max(maxLen, j - i - 1);
            }

            while (cZero > 1) {
                if (nums[i] == 0) {
                    cZero--;
                }
                i++;
            }
        }

        return maxLen;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.longestSubarray(new int[]{1, 1, 0, 1}));
        assertEquals(5, s.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        assertEquals(2, s.longestSubarray(new int[]{1, 1, 1}));
    }
}
