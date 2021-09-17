package byx.leetcode.problem.盛最多水的容器;

import byx.leetcode.common.Checker;
import byx.leetcode.common.Check;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution1 {
    @Check
    public int maxArea(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                result = Math.max(result, Math.min(nums[i], nums[j]) * (j - i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Checker.check(Solution1.class, 49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Checker.check(Solution1.class, 1, new int[]{1, 1});
        Checker.check(Solution1.class, 16, new int[]{4, 3, 2, 1, 4});
        Checker.check(Solution1.class, 2, new int[]{1, 2, 1});
    }
}
