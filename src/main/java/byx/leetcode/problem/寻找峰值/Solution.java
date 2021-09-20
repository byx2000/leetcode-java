package byx.leetcode.problem.寻找峰值;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 1, right = nums.length - 1;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1]) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(solution.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
