package byx.leetcode.problem.中位数;

/**
 * https://www.lintcode.com/problem/80/description
 */
public class Solution {
    public int median(int[] nums) {
        return findKthLargest(nums, nums.length / 2 + 1);
    }

    private int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int mid = partition(nums, left, right);
            if (right - mid + 1 == k) {
                return nums[mid];
            } else if (right - mid + 1 < k) {
                k -= (right - mid + 1);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int partition(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && nums[i] < nums[left]) i++;
            while (i <= j && nums[j] >= nums[left]) j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.median(new int[]{4, 5, 1, 2, 3}));
        System.out.println(solution.median(new int[]{7, 9, 4, 5}));
    }
}
