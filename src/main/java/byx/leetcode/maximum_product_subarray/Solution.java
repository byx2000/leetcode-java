package byx.leetcode.maximum_product_subarray;

// https://leetcode.cn/problems/maximum-product-subarray/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int t1 = maxProd;
            int t2 = minProd;
            maxProd = Math.max(nums[i], Math.max(t1 * nums[i], t2 * nums[i]));
            minProd = Math.min(nums[i], Math.min(t1 * nums[i], t2 * nums[i]));
            result = Math.max(result, maxProd);
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, s.maxProduct(new int[]{-2, 0, -1}));
        assertEquals(12, s.maxProduct(new int[]{-4, -3, -2}));
    }
}
