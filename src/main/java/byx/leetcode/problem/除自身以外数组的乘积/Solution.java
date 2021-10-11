package byx.leetcode.problem.除自身以外数组的乘积;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] p1 = new int[nums.length];
        p1[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            p1[i] = p1[i - 1] * nums[i];
        }

        int[] p2 = new int[nums.length];
        p2[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            p2[i] = p2[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int left = (i == 0) ? 1 : p1[i - 1];
            int right = (i == nums.length - 1) ? 1 : p2[i + 1];
            result[i] = left * right;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
