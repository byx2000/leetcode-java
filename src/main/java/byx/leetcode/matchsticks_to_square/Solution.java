package byx.leetcode.matchsticks_to_square;

// https://leetcode.cn/problems/matchsticks-to-square/

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    private int sum = 0;

    public boolean makesquare(int[] matchsticks) {
        matchsticks = Arrays.stream(matchsticks).boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(n -> n)
                .toArray();

        for (int n : matchsticks) {
            sum += n;
        }

        if (sum % 4 != 0) {
            return false;
        }

        sum /= 4;

        return dfs(matchsticks, 0, new int[]{0, 0, 0, 0});
    }

    private boolean dfs(int[] nums, int index, int[] edge) {
        if (index == nums.length) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (edge[i] + nums[index] <= sum) {
                edge[i] += nums[index];
                if (dfs(nums, index + 1, edge)) {
                    return true;
                }
                edge[i] -= nums[index];
            }
        }

        return false;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.makesquare(new int[]{1, 1, 2, 2, 2}));
        assertFalse(s.makesquare(new int[]{3, 3, 3, 3, 4}));
    }
}
