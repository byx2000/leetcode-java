package byx.leetcode.problem.盛最多水的容器;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution1 {
    public int maxArea(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                result = Math.max(result, Math.min(nums[i], nums[j]) * (j - i));
            }
        }
        return result;
    }
}
