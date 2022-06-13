package byx.leetcode.next_greater_element_ii;

// https://leetcode.cn/problems/next-greater-element-ii/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public int[] nextGreaterElements(int[] arr) {
        // 将arr复制一份，并拼接起来
        int[] nums = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
            nums[i + arr.length] = arr[i];
        }

        // dp[i]表示nums[i]右边第一个大于nums[i]的元素下标
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = -1;

        int[] result = new int[nums.length];
        result[nums.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j != -1 && nums[j] <= nums[i]) {
                j = dp[j];
            }
            dp[i] = j;
            result[i] = dp[i] == -1 ? -1 : nums[dp[i]];
        }

        int[] r = new int[nums.length / 2];
        System.arraycopy(result, 0, r, 0, r.length);

        return r;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{2, -1, 2}, s.nextGreaterElements(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{2, 3, 4, -1, 4}, s.nextGreaterElements(new int[]{1, 2, 3, 4, 3}));
    }
}
