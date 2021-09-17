package byx.leetcode.problem.盛最多水的容器;

import byx.leetcode.common.Check;
import byx.leetcode.common.Checker;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution2 {
    @Check
    public int maxArea(int[] nums) {
        int i = 0, j = nums.length - 1;
        int result = Integer.MIN_VALUE;
        while (i < j) {
            if (nums[i] < nums[j]) {
                result = Math.max(result, nums[i] * (j - i));
                i++;
            } else {
                result = Math.max(result, nums[j] * (j - i));
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Checker.check(Solution2.class, 49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Checker.check(Solution2.class, 1, new int[]{1, 1});
        Checker.check(Solution2.class, 16, new int[]{4, 3, 2, 1, 4});
        Checker.check(Solution2.class, 2, new int[]{1, 2, 1});
    }
}
