package byx.leetcode.problem.乘积最大子数组;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int[] min = new int[nums.length];
        min[0] = nums[0];
        int maxVal = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            max[i] = Math.max(Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            min[i] = Math.min(Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            maxVal = Math.max(maxVal, max[i]);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));
    }
}
