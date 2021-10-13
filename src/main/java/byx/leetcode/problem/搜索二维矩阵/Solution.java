package byx.leetcode.problem.搜索二维矩阵;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int left = 0, right = nums.length * nums[0].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / nums[0].length;
            int c = mid % nums[0].length;

            if (nums[r][c] == target) {
                return true;
            } else if (nums[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
