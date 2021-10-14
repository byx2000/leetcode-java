package byx.leetcode.problem.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        int layer = 0;
        int row = nums.length;
        int col = nums[0].length;
        List<Integer> result = new ArrayList<>();

        while (true) {
            int left = layer;
            int top = layer;
            int right = col - 1 - layer;
            int bottom = row - 1 - layer;

            if (left > right || top > bottom) {
                break;
            }

            for (int i = left; i <= right; ++i) {
                result.add(nums[top][i]);
            }

            for (int i = top + 1; i <= bottom - 1; ++i) {
                result.add(nums[i][right]);
            }

            if (top != bottom) {
                for (int i = right; i >= left; --i) {
                    result.add(nums[bottom][i]);
                }
            }

            if (left != right) {
                for (int i = bottom - 1; i >= top + 1; --i) {
                    result.add(nums[i][left]);
                }
            }

            layer++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
