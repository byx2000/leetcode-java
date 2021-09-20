package byx.leetcode.problem.搜索旋转排序数组;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int pos = find(nums, 0, minIndex - 1, target);
        if (pos != -1) {
            return pos;
        }
        return find(nums, minIndex, nums.length - 1, target);
    }

    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    private int find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1}, 0));
    }
}
