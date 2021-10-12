package byx.leetcode.problem.查找插入位置;

/**
 * https://leetcode-cn.com/problems/N6YdxV/
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(solution.searchInsert(new int[]{1}, 0));
    }
}
