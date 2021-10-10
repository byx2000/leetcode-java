package byx.leetcode.problem.乘积小于K的子数组;

/**
 * https://leetcode-cn.com/problems/ZVAVXX/
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }

        int i = 0, j = 0;
        int product = 1;
        int cnt = 0;

        while (j < nums.length) {
            if (product < k) {
                cnt += j - i;
                product *= nums[j];
                j++;
            } else {
                product /= nums[i];
                i++;
            }
        }

        while (product >= k) {
            product /= nums[i];
            i++;
        }

        cnt += j - i;

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 1));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }
}
