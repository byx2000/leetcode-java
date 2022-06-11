package byx.leetcode.maximal_rectangle;

// https://leetcode.cn/problems/maximal-rectangle/

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[] nums = new int[matrix[0].length];
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                nums[j] = matrix[i][j] == '1' ? nums[j] + 1 : 0;
            }
            result = Math.max(result, maxArea(nums));
        }

        return result;
    }

    // 参见 https://leetcode.cn/problems/largest-rectangle-in-histogram/
    private int maxArea(int[] nums) {
        // left[i]表示nums[i]左边第一个小于nums[i]的元素下标
        int[] left = new int[nums.length];
        left[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            while (j != -1 && nums[j] >= nums[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        // right[i]表示nums[i]右边第一个小于nums[i]的元素下标
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums.length;
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j != nums.length && nums[j] >= nums[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, nums[i] * (right[i] - left[i] - 1));
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
        assertEquals(0, s.maximalRectangle(new char[][]{}));
        assertEquals(1, s.maximalRectangle(new char[][]{{'1'}}));
        assertEquals(0, s.maximalRectangle(new char[][]{{'0', '0'}}));
    }
}
