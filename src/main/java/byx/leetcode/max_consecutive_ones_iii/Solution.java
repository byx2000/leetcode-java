package byx.leetcode.max_consecutive_ones_iii;

// https://leetcode.cn/problems/max-consecutive-ones-iii/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        // 找到包含最多k个0的最长子数组

        int i = 0;
        int j = 0;
        int cZero = 0;
        int maxLen = 0;

        while (j < nums.length) {
            // j向右移动，直到区间[i, j)中0的个数 > k
            while (j < nums.length && cZero <= k) {
                maxLen = Math.max(maxLen, j - i);
                if (nums[j] == 0) {
                    cZero++;
                }
                j++;
            }

            if (j == nums.length && cZero <= k) {
                maxLen = Math.max(maxLen, j - i);
            }

            // i向右移动，直到区间[i, j)中0的个数 <= k
            while (cZero > k) {
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
        assertEquals(6, s.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        assertEquals(10, s.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        assertEquals(4, s.longestOnes(new int[]{0, 0, 0, 1}, 4));
    }
}
