package byx.leetcode.problem.寻找旋转排序数组中的最小值;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {
    public int findMin(int[] nums) {
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

        return nums[result];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(solution.findMin(new int[]{11,13,15,17}));
    }
}
