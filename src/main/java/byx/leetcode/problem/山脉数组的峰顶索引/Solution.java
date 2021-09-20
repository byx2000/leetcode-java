package byx.leetcode.problem.山脉数组的峰顶索引;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 1, right = nums.length - 1;
        int result = -1;
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
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0,2,1,0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0,10,5,2}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{3,4,5,1}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
