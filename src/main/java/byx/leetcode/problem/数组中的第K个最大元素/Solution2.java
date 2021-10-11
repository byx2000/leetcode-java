package byx.leetcode.problem.数组中的第K个最大元素;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Solution2 {
    private static final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
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
        swap(nums, left, left + random.nextInt(right - left + 1));
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && nums[i] <= nums[left]) i++;
            while (i <= j && nums[j] > nums[left]) j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
