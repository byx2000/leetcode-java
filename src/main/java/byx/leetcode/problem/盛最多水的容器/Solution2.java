package byx.leetcode.problem.盛最多水的容器;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution2 {
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
}
