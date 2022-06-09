package byx.leetcode.daily_temperatures;

// https://leetcode.cn/problems/daily-temperatures/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public int[] dailyTemperatures(int[] nums) {
        // dp[i]表示nums[i]右边第一个大于nums[i]的元素下标
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = -1;

        int[] result = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j != -1 && nums[i] >= nums[j]) {
                j = dp[j];
            }
            dp[i] = j;
            result[i] = dp[i] == -1 ? 0 : dp[i] - i;
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{1, 1, 1, 0}, s.dailyTemperatures(new int[]{30, 40, 50, 60}));
        assertArrayEquals(new int[]{1, 1, 0}, s.dailyTemperatures(new int[]{30, 60, 90}));
    }
}
