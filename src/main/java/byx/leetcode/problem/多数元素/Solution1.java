package byx.leetcode.problem.多数元素;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class Solution1 {
    private static final Random random = new Random();

    public int majorityElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int k = nums.length / 2 + 1;

        while (true) {
            int mid = partition(nums, left, right);
            int cnt = mid - left + 1;

            if (cnt == k) {
                return nums[mid];
            } else if (cnt < k) {
                k -= cnt;
                left = mid + 1;
            } else {
                right = mid - 1;
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
        Solution1 solution = new Solution1();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
