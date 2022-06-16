package byx.leetcode.target_sum;

// https://leetcode.cn/problems/target-sum/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private int[] nums;
    private Integer[][] cache;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.cache = new Integer[nums.length][4000];
        return dp(nums.length - 1, target);
    }

    // 给nums[0~index]加运算符，使得结果等于target的方法数
    private int dp(int index, int target) {
        if (cache[index][target + 2000] != null) {
            return cache[index][target + 2000];
        }

        if (index == 0) {
            int r = 0;
            if (nums[0] == target) {
                r++;
            }
            if (-nums[0] == target) {
                r++;
            }
            return cache[index][target + 2000] = r;
        }

        return cache[index][target + 2000] = dp(index - 1, target - nums[index]) + dp(index - 1, target + nums[index]);
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        assertEquals(1, s.findTargetSumWays(new int[]{1}, 1));
    }
}
