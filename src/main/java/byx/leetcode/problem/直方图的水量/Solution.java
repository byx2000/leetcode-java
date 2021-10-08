package byx.leetcode.problem.直方图的水量;

/**
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class Solution {
    public int trap(int[] height) {
        int h = 1;
        int sum = 0;

        while (true) {
            int i = 0;
            while (i < height.length && height[i] < h) {
                i++;
            }

            if (i == height.length) {
                break;
            }

            int j = height.length - 1;
            while (height[j] < h) {
                j--;
            }

            for (int k = i; k <= j; ++k) {
                if (height[k] < h) {
                    sum++;
                }
            }

            h++;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
